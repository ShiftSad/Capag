package dev.shiftsad.capag.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ConversationAnswerResponseDto {
    private String conversationId;
    private String status;
    private List<Map<String, String>> questions;
    private String header;
    private String itemsCsv;
    private String filename;
}