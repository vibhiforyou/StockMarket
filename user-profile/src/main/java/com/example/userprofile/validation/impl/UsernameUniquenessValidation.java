package com.example.userprofile.validation.impl;

import com.example.userprofile.model.dto.UserProfileDTO;
import com.example.userprofile.repository.UserProfileRepository;
import com.example.userprofile.validation.SecondaryValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsernameUniquenessValidation implements SecondaryValidation {

    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UsernameUniquenessValidation(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public String check(UserProfileDTO userProfileDTO) {
        String INVALID_USERNAME = "username already exist";
        return userProfileRepository.getUsernameCount(userProfileDTO.username()) != 0 ? INVALID_USERNAME : null;
    }
}
