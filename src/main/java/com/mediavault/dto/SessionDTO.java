package com.mediavault.dto;

import java.time.LocalDateTime;

public class SessionDTO {
    private Long id;
    private String accessToken;
    private LocalDateTime createdAt = LocalDateTime.now();

    public SessionDTO() {}

    public SessionDTO(Long id, String accessToken, LocalDateTime createdAt) {
        this.id = id;
        this.accessToken = accessToken;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
