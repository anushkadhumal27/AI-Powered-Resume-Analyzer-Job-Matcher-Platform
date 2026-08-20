package com.resumeanalyzer.model.dto;

public class TextAnalyzeRequestDto {
    private String text;
    private String filename;
    private String targetRole;

    public TextAnalyzeRequestDto() {}

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getFilename() { return filename; }
    public void setFilename(String filename) { this.filename = filename; }

    public String getTargetRole() { return targetRole; }
    public void setTargetRole(String targetRole) { this.targetRole = targetRole; }
}
