package com.example.userprofile.validation.impl;

import com.example.userprofile.model.dto.UserProfileDTO;
import com.example.userprofile.repository.UserProfileRepository;
import com.example.userprofile.validation.SecondaryValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailUniquenessValidation implements SecondaryValidation {

    private final UserProfileRepository userProfileRepository;

    @Autowired
    public EmailUniquenessValidation(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public String check(UserProfileDTO userProfileDTO) {
        String INVALID_EMAIL = "email id already exist";
        return userProfileRepository.getEmailCount(userProfileDTO.email()) != 0 ? INVALID_EMAIL : null;
    }

}
