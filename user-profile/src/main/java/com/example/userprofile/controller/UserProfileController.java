package com.example.userprofile.controller;

import com.example.userprofile.exception.BadRequestException;
import com.example.userprofile.model.bo.UserProfile;
import com.example.userprofile.model.dto.UserProfileDTO;
import com.example.userprofile.service.UserProfileService;
import com.example.userprofile.validation.impl.SecondaryCheckProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/v1/user-profile")
@SuppressWarnings("unused")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private SecondaryCheckProcessing secondaryCheckProcessing;

    @GetMapping
    public ResponseEntity<List<UserProfile>> getUserProfiles() {
        List<UserProfile> response = userProfileService.getUserProfiles();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDTO> getUserProfilesById(@PathVariable(name = "id") UUID id) {
        UserProfileDTO response = userProfileService.getUserProfilesById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<String> saveUserProfile(@RequestBody UserProfileDTO userProfileDTO) {
        if (!checkEmailValidation(userProfileDTO)) throw new BadRequestException("invalid email format");
        if (!checkPhoneValidation(userProfileDTO)) throw new BadRequestException("invalid phone number format");

        String response = checkSecondaryValidation(userProfileDTO);
        if (response != null) throw new BadRequestException(response);

        userProfileService.saveUserProfile(userProfileDTO);
        return ResponseEntity.ok("user saved ");
    }

    private Boolean checkEmailValidation(UserProfileDTO userProfileDTO) {
        String emailPattern = "(([a-zA-Z0-9]+)([\\.\\-_]?)([a-zA-Z0-9]+)([\\.\\-_]?)([a-zA-Z0-9]+)?)(@)([a-zA-Z]+.[A-Za-z]+\\.?([a-zA-Z0-9]+)\\.?([a-zA-Z0-9]+))";
        return Pattern.compile(emailPattern).matcher(userProfileDTO.email()).matches();
    }

    private Boolean checkPhoneValidation(UserProfileDTO userProfileDTO) {
        String phonePattern = "^\\d{10}";
        return Pattern.compile(phonePattern).matcher(userProfileDTO.phone()).matches();
    }

    private String checkSecondaryValidation(UserProfileDTO userProfileDTO) {
        return secondaryCheckProcessing.process(userProfileDTO);
    }
}

