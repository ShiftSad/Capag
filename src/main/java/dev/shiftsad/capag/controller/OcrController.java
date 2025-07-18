package dev.shiftsad.capag.controller;

import dev.shiftsad.capag.service.PdfOcrService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

@AllArgsConstructor
@RestController
public class OcrController {

    private final PdfOcrService pdfOcrService;

    @Cacheable("ocrPdf")
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/ocr/pdf", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<String> ocrPdf(@RequestPart("file") Mono<FilePart> file) {
        return file
                .flatMap(fp -> fp.content()
                        .publishOn(Schedulers.boundedElastic())
                        .reduce(new ByteArrayOutputStream(), (baos, dataBuffer) -> {
                            ByteBuffer buffer = ByteBuffer.allocate(dataBuffer.readableByteCount());
                            dataBuffer.toByteBuffer(buffer);
                            baos.write(buffer.array(), buffer.position(), buffer.remaining());
                            return baos;
                        })
                        .map(ByteArrayOutputStream::toByteArray)
                        .map(pdfOcrService::extractTextFromPdf)
                        .onErrorResume(e -> Mono.just("Error processing PDF file: " + e.getMessage()))
                );
    }
}