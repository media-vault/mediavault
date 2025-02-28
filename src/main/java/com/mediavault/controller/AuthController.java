package com.mediavault.controller;

import com.mediavault.entity.Role;
import com.mediavault.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register") 
    public ResponseEntity<Map<String, String>> register(@RequestBody Map<String, String> request) {
        String token = authService.registerUser(request.get("username"), request.get("password"), Role.valueOf(request.get("role").toUpperCase()));
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/login") 
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> request) {
        String token = authService.loginUser(request.get("username"), request.get("password"));
        return ResponseEntity.ok(Map.of("token", token));
    }
}
