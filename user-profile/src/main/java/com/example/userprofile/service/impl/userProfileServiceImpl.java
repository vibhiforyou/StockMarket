package com.example.userprofile.service.impl;

import com.example.userprofile.model.bo.UserProfile;
import com.example.userprofile.model.dto.UserProfileDTO;
import com.example.userprofile.repository.UserProfileRepository;
import com.example.userprofile.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Service
@SuppressWarnings("unused")
public class userProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;


    @Override
    public List<UserProfile> getUserProfiles() {
        return userProfileRepository.getAllUserProfiles();
    }

    @Override
    public UserProfileDTO getUserProfilesById(UUID id) {
        UserProfile userProfile = userProfileRepository.getReferenceById(id);
        return new UserProfileDTO(
                userProfile.getFirstName(),
                userProfile.getLastName(),
                userProfile.getEmail(),
                userProfile.getPhone(),
                userProfile.getUsername(),
                userProfile.getPassword()
        );
    }

    @Override
    public void saveUserProfile(UserProfileDTO userProfile) {
        userProfileRepository.saveUserProfile(
                userProfile.firstName(),
                userProfile.lastName(),
                userProfile.email(),
                userProfile.phone(),
                userProfile.username(),
                userProfile.password(),
                OffsetDateTime.now(),
                OffsetDateTime.now(),
                "SYSTEM",
                "SYSTEM"
        );
    }
}
