package com.example.userprofile.validation.impl;

import com.example.userprofile.model.dto.UserProfileDTO;
import com.example.userprofile.repository.UserProfileRepository;
import com.example.userprofile.validation.SecondaryValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PhoneUniquenessValidation implements SecondaryValidation {

    private final UserProfileRepository userProfileRepository;

    @Autowired
    public PhoneUniquenessValidation(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public String check(UserProfileDTO userProfileDTO) {
        String INVALID_PHONE="phone number already exist";
        return userProfileRepository.getPhoneCount(userProfileDTO.phone())!=0?INVALID_PHONE:null;
    }
}
