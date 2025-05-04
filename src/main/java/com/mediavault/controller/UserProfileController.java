package com.mediavault.controller;

import com.mediavault.entity.UserProfile;
import com.mediavault.service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user/{userId}/profile")
public class UserProfileController {

    private final UserProfileService profileService;

    public UserProfileController(UserProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public ResponseEntity<UserProfile> getProfile(@PathVariable Long userId) {
        return profileService.getProfile(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserProfile> saveProfile(@PathVariable Long userId, @RequestBody UserProfile profileData) {
        UserProfile saved = profileService.createOrUpdateProfile(userId, profileData);
        return ResponseEntity.ok(saved);
    }
}
