package dev.shiftsad.capag.dto;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

@Data
public class ConversationCreateResponseDto {
    private String conversation_id;
    private String status;
    @Nullable
    private String model;
    @Nullable
    private List<Map<String, Object>> questions; // Optional[List[Dict]]
    @Nullable
    private String header;
    @Nullable
    private String items_csv;
    @Nullable
    private String filename;
}