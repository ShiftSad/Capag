package dev.shiftsad.capag.controller;

import dev.shiftsad.capag.dto.ConversationAnswerRequestDto;
import dev.shiftsad.capag.dto.ConversationAnswerResponseDto;
import dev.shiftsad.capag.dto.ConversationCreateResponseDto;
import dev.shiftsad.capag.dto.HealthCheckResponseDto;
import dev.shiftsad.capag.service.ContentParserService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/parser")
@CrossOrigin(origins = "*")
public class ContentParserController {

    private final ContentParserService contentParserService;

    @PostMapping(value = "/conversation", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<ConversationCreateResponseDto> createConversation(
            @RequestPart("pdf_file") Mono<FilePart> filePart,
            @RequestPart(name = "model", required = false) String model) {

        return filePart
                .flatMap(part -> {
                    // Ensure a file was actually uploaded
                    if (part.filename().isEmpty()) {
                        return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "PDF file is required."));
                    }
                    // Convert the FilePart content (Flux<DataBuffer>) into a single byte array
                    Mono<byte[]> content = DataBufferUtils.join(part.content())
                            .map(dataBuffer -> {
                                byte[] bytes = new byte[dataBuffer.readableByteCount()];
                                dataBuffer.read(bytes);
                                DataBufferUtils.release(dataBuffer);
                                return bytes;
                            });

                    return content.flatMap(bytes ->
                            contentParserService.createConversation(part.filename(), bytes, model)
                    );
                });
    }

    @PostMapping("/conversation/answer")
    public Mono<ConversationAnswerResponseDto> answerQuestions(
            @RequestBody Mono<ConversationAnswerRequestDto> requestDtoMono) {
        return requestDtoMono.flatMap(contentParserService::answerQuestions);
    }

    @Cacheable("conversation")
    @GetMapping("/conversation/{id}")
    public Mono<ConversationCreateResponseDto> getConversation(@PathVariable String id) {
        return contentParserService.getConversation(id);
    }

    @GetMapping("/conversation/debug/{id}")
    public Mono<Map<String, Object>> getDebugConversation(@PathVariable String id) {
        return contentParserService.getDebugConversation(id);
    }

    @GetMapping("/health")
    public Mono<HealthCheckResponseDto> checkHealth() {
        return contentParserService.healthCheck();
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleRuntimeException(RuntimeException ex) {
        return Map.of("error", "Ocorreu um erro: " + ex.getMessage());
    }

    @ExceptionHandler(ServerWebInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleInputException(ServerWebInputException ex) {
        return Map.of("error", "Entrada inválida: " + ex.getReason());
    }
}
