package com.example.userprofile.controller;

import com.example.userprofile.model.bo.UserProfile;
import com.example.userprofile.model.dto.UserProfileDTO;
import com.example.userprofile.service.UserProfileService;
import com.example.userprofile.validation.SecondaryValidation;
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
        if (!checkPrimaryValidation(userProfileDTO)) return ResponseEntity.badRequest().body("email/phone invalid");
        String response = checkSecondaryValidation(userProfileDTO);
        if (response != null) return ResponseEntity.badRequest().body(response);
        userProfileService.saveUserProfile(userProfileDTO);
        return ResponseEntity.ok("user saved ");
    }

    private Boolean checkPrimaryValidation(UserProfileDTO userProfileDTO) {
        String emailPattern = "(([a-zA-Z0-9]+)([\\.\\-_]?)([a-zA-Z0-9]+)([\\.\\-_]?)([a-zA-Z0-9]+)?)(@)([a-zA-Z]+.[A-Za-z]+\\.?([a-zA-Z0-9]+)\\.?([a-zA-Z0-9]+))";
        boolean emailValidation = Pattern.compile(emailPattern).matcher(userProfileDTO.email()).matches();

        String phonePattern = "^\\d{10}";
        boolean phoneValidation = Pattern.compile(phonePattern).matcher(userProfileDTO.phone()).matches();
        return emailValidation && phoneValidation;
    }

    private String checkSecondaryValidation(UserProfileDTO userProfileDTO) {
        return secondaryCheckProcessing.process(userProfileDTO);
    }
}

