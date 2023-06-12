package com.example.userprofile.model.dto;

public record ErrorDTO(
        Integer statusCode,
        String message,
        long timestamp
) {
}
