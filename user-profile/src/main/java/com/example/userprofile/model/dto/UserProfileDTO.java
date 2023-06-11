package com.example.userprofile.model.dto;

public record UserProfileDTO(
        String firstName,
        String lastName,
        String email,
        String phone,
        String username,
        String password

) {
}
