package dev.shiftsad.capag.dto;

import lombok.Data;
import java.util.Map;

@Data
public class ConversationAnswerRequestDto {
    private String conversationId;
    private Map<String, String> answers;
}