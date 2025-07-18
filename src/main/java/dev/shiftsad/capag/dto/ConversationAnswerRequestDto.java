package dev.shiftsad.capag.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ConversationAnswerRequestDto {
    private String conversation_id;
    private Map<String, String> answers;
}