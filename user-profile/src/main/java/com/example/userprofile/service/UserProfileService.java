package com.example.userprofile.service;

import com.example.userprofile.model.dto.UserProfileDTO;
import com.example.userprofile.model.bo.UserProfile;

import java.util.List;
import java.util.UUID;

public interface UserProfileService {
    List<UserProfile> getUserProfiles();

    UserProfileDTO getUserProfilesById(UUID id);

    void  saveUserProfile(UserProfileDTO userProfile);
}
