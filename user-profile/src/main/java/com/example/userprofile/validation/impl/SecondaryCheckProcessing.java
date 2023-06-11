package com.example.userprofile.validation.impl;

import com.example.userprofile.model.dto.UserProfileDTO;
import com.example.userprofile.validation.SecondaryValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SecondaryCheckProcessing {

    private final List<SecondaryValidation> primaryValidationList;

    @Autowired
    public SecondaryCheckProcessing(List<SecondaryValidation> primaryValidationList) {
        this.primaryValidationList = primaryValidationList;
    }

    public String process(UserProfileDTO userProfileDTO) {
        StringBuilder errorMsg = new StringBuilder();
        for (SecondaryValidation primaryCheck : primaryValidationList) {
            String response = primaryCheck.check(userProfileDTO);
            if (response != null)
                errorMsg.append(response).append("/");
        }
        return !errorMsg.toString().equals("") ?StringUtils.trimTrailingCharacter(errorMsg.toString(),'/'):null;
    }
}
