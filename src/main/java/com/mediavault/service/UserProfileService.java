package com.mediavault.service;

import com.mediavault.entity.UserProfile;
import com.mediavault.entity.User;
import com.mediavault.repository.UserProfileRepository;
import com.mediavault.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService {

    private final UserProfileRepository profileRepository;
    private final UserRepository userRepository;

    public UserProfileService(UserProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    public Optional<UserProfile> getProfile(Long userId) {
        return profileRepository.findById(userId);
    }

    public UserProfile saveProfile(UserProfile userProfile) {
        return profileRepository.save(userProfile);
    }

    public UserProfile createOrUpdateProfile(Long userId, UserProfile profileData) {
        User user = userRepository.findById(userId)
                     .orElseThrow(() -> new RuntimeException("User not found"));

        Optional<UserProfile> existingOpt = profileRepository.findById(userId);

        if (existingOpt.isPresent()) {
            UserProfile existing = existingOpt.get();
            existing.setDisplayName(profileData.getDisplayName());
            existing.setAvatarUrl(profileData.getAvatarUrl());
            existing.setBio(profileData.getBio());
            existing.setLanguage(profileData.getLanguage());
            existing.setCountry(profileData.getCountry());
            return profileRepository.save(existing);
        } else {
            profileData.setUser(user);
            return profileRepository.save(profileData);
        }
    }
}
