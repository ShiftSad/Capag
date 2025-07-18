package dev.shiftsad.capag.dto;

import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

@Data
public class ConversationAnswerResponseDto {
    private String conversation_id;
    private String status;
    @Nullable
    private List<Map<String, Object>> questions;
    @Nullable
    private String header;
    @Nullable
    private String items_csv;
    @Nullable
    private String filename;
}