package com.mediavault.service;

import com.mediavault.entity.UserPreferences;
import com.mediavault.entity.User;
import com.mediavault.repository.UserPreferencesRepository;
import com.mediavault.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPreferencesService{

    private final UserPreferencesRepository preferencesRepository;
    private final UserRepository userRepository;

    public UserPreferencesService(UserPreferencesRepository preferencesRepository, UserRepository userRepository) {
        this.preferencesRepository = preferencesRepository;
        this.userRepository = userRepository;
    }

    public Optional<UserPreferences> getPreferences(Long userId) {
        return preferencesRepository.findById(userId);
    }

    public UserPreferences savePreferences(UserPreferences userPreferences) {
        return preferencesRepository.save(userPreferences);
    }

    public UserPreferences createOrUpdatePreferences(Long userId, UserPreferences preferencesData) {
        User user = userRepository.findById(userId)
                     .orElseThrow(() -> new RuntimeException("User not found"));

        Optional<UserPreferences> existingOpt = preferencesRepository.findById(userId);

        if (existingOpt.isPresent()) {
            UserPreferences existing = existingOpt.get();
            existing.setDarkMode(preferencesData.getDarkMode());
            existing.setDefaultLibraryView(preferencesData.getDefaultLibraryView());
            return preferencesRepository.save(existing);
        } else {
            preferencesData.setUser(user);
            return preferencesRepository.save(preferencesData);
        }
    }
}
