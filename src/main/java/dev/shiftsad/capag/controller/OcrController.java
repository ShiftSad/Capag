package dev.shiftsad.capag.controller;

import dev.shiftsad.capag.service.PdfOcrService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RestController
public class OcrController {

    private final PdfOcrService pdfOcrService;

    @Cacheable("ocrPdf")
    @CrossOrigin(origins = "*")
    @PostMapping("/ocr/pdf")
    public String ocrPdf(@RequestParam("file") MultipartFile file) {
        try {
            return pdfOcrService.extractTextFromPdf(file.getBytes());
        } catch (Exception e) {
            return "Error processing PDF file: " + e.getMessage();
        }
    }
}
