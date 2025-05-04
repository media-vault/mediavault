package com.mediavault.controller;

import com.mediavault.entity.UserPreferences;
import com.mediavault.service.UserPreferencesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user/{userId}/preferences")
public class UserPreferencesController {

    private final UserPreferencesService preferencesService;

    public UserPreferencesController(UserPreferencesService preferencesService) {
        this.preferencesService = preferencesService;
    }

    @GetMapping
    public ResponseEntity<UserPreferences> getPreferences(@PathVariable Long userId) {
        return preferencesService.getPreferences(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserPreferences> savePreferences(@PathVariable Long userId, @RequestBody UserPreferences preferencesData) {
        UserPreferences saved = preferencesService.createOrUpdatePreferences(userId, preferencesData);
        return ResponseEntity.ok(saved);
    }
}
