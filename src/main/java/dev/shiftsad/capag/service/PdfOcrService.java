package dev.shiftsad.capag.service;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Service
public class PdfOcrService {

    private final static String tessDataPath = "src/main/resources/tessdata";
    private final static Logger logger = LoggerFactory.getLogger(PdfOcrService.class);

    private final static ExecutorService ocrExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public String extractTextFromPdf(byte[] pdfBytes) {
        logger.info("Iniciando extração de texto, tamanho: {} bytes", pdfBytes.length);
        RandomAccessRead randomAccessRead = new RandomAccessReadBuffer(pdfBytes);
        try (PDDocument document = Loader.loadPDF(
                randomAccessRead,
                null,
                null,
                null,
                IOUtils.createTempFileOnlyStreamCache())) {

            PDFRenderer renderer = new PDFRenderer(document);
            int pageCount = document.getNumberOfPages();
            logger.info("Número de páginas: {}", pageCount);

            List<BufferedImage> images = new ArrayList<>(pageCount);
            for (int i = 0; i < pageCount; i++) {
                try {
                    images.add(renderer.renderImageWithDPI(i, 300, ImageType.GRAY));
                } catch (IOException e) {
                    logger.error("Falha ao renderizar página {}: {}", i, e.getMessage());
                    images.add(null);
                }
            }

            List<CompletableFuture<PageText>> futures = new ArrayList<>(pageCount);
            for (int i = 0; i < images.size(); i++) {
                final int idx = i;
                BufferedImage img = images.get(i);
                futures.add(CompletableFuture
                        .supplyAsync(() -> doOcr(img, idx), ocrExecutor)
                        .exceptionally(e -> {
                            logger.error("Erro OCR página {}: {}", idx, e.getMessage());
                            return new PageText(idx, "");
                        }));
            }

            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

            String result = futures.stream()
                    .map(CompletableFuture::join)
                    .sorted(Comparator.comparingInt(PageText::index))
                    .map(PageText::text)
                    .collect(Collectors.joining("\n"));

            logger.info("Extração concluída");
            return result;

        } catch (IOException e) {
            logger.error("Erro ao carregar PDF: {}", e.getMessage());
            return "";
        }
    }

    private PageText doOcr(BufferedImage image, int index) {
        if (image == null) {
            return new PageText(index, "");
        }
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath(tessDataPath);
        tesseract.setLanguage("por");
        tesseract.setPageSegMode(3);
        tesseract.setOcrEngineMode(1);
        try {
            String text = tesseract.doOCR(image);
            return new PageText(index, text);
        } catch (TesseractException e) {
            logger.error("TesseractException página {}: {}", index, e.getMessage());
            return new PageText(index, "");
        }
    }

    private record PageText(int index, String text) { }
}