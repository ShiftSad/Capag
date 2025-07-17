package dev.shiftsad.capag.dto;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class ConversationCreateResponseDto {
    private String conversationId;
    private String status;
    private String model;
    private List<Map<String, String>> questions; // Represents List[Dict]
    private String header;
    private String itemsCsv;
    private String filename;
}