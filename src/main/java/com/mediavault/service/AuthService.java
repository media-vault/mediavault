package com.mediavault.service;

import com.mediavault.entity.User;
import com.mediavault.entity.Session;
import com.mediavault.entity.Role;
import com.mediavault.repository.UserRepository;
import com.mediavault.repository.SessionRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, SessionRepository sessionRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(String username, String password) {
       if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("User already exists");
       }

       String hashedPassword = passwordEncoder.encode(password);

       User newUser = new User();
       newUser.setUsername(username);
       newUser.setPassword(hashedPassword);
       newUser.setRole(Role.USER);

       userRepository.save(newUser);

       return "Success creating User";
    }

    public String login(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isEmpty()) {
            throw new RuntimeException("Invalid credentials");
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        sessionRepository.findByUserId(user.getId()).ifPresent(sessionRepository::delete);

        String apiKey = UUID.randomUUID().toString();

        Session session = new Session();
        session.setUser(user);
        session.setAccessToken(apiKey);
        sessionRepository.save(session);

        return apiKey;
    }

    public void logout(String accessToken) {
        sessionRepository.deleteByAccessToken(accessToken);
    }
}
