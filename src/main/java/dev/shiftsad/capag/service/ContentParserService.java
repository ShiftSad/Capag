package dev.shiftsad.capag.service;

import dev.shiftsad.capag.dto.ConversationAnswerRequestDto;
import dev.shiftsad.capag.dto.ConversationAnswerResponseDto;
import dev.shiftsad.capag.dto.ConversationCreateResponseDto;
import dev.shiftsad.capag.dto.HealthCheckResponseDto;
import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
@NoArgsConstructor
public class ContentParserService {

    @Value("${microservices.python.api-key}")
    private String apiKey;

    @Value("${microservices.python.url}")
    private String baseUrl;

    private WebClient webClient;

    @PostConstruct
    public void init() {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .build();
    }

    public Mono<ConversationCreateResponseDto> createConversation(
            String pdfFileName, byte[] pdfContent, String model) {

        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        builder.part("pdf_file", new ByteArrayResource(pdfContent))
                .contentType(MediaType.APPLICATION_PDF)
                .filename(pdfFileName);

        // Only add model part if it's provided and not empty
        if (model != null && !model.trim().isEmpty()) {
            builder.part("model", model);
        }

        return webClient.post()
                .uri("/conversation/create")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(builder.build()))
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(
                                        new RuntimeException("API Error: " + errorBody))))
                .bodyToMono(ConversationCreateResponseDto.class);
    }

    public Mono<ConversationAnswerResponseDto> answerQuestions(
            ConversationAnswerRequestDto requestDto) {
        return webClient.post()
                .uri("/conversation/answer")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestDto)
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(
                                        new RuntimeException("API Error: " + errorBody))))
                .bodyToMono(ConversationAnswerResponseDto.class);
    }

    public Mono<ConversationCreateResponseDto> getConversation(String conversationId) {
        return webClient.get()
                .uri("/conversation/{conversation_id}", conversationId)
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(
                                        new RuntimeException("API Error: " + errorBody))))
                .bodyToMono(ConversationCreateResponseDto.class);
    }

    public Mono<Map<String, Object>> getDebugConversation(String conversationId) {
        return webClient.get()
                .uri("/debug/conversation/{conversation_id}", conversationId)
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(
                                        new RuntimeException("API Error: " + errorBody))))
                .bodyToMono(new ParameterizedTypeReference<>() {});
    }

    public Mono<HealthCheckResponseDto> healthCheck() {
        return webClient.get()
                .uri("/health")
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(
                                        new RuntimeException("API Error: " + errorBody))))
                .bodyToMono(HealthCheckResponseDto.class);
    }
}
