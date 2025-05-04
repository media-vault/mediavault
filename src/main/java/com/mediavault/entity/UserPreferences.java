package com.mediavault.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_preferences")
public class UserPreferences {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    private boolean darkMode = false;
    private String defaultLibraryView; // "grid", "list", etc.
    
    public UserPreferences() {}

    public UserPreferences(Long id, User user, boolean darkMode, String defaultLibraryView) {
        this.id = id;
        this.user = user;
        this.darkMode = darkMode;
        this.defaultLibraryView = defaultLibraryView;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean getDarkMode() {
        return darkMode;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }

    public String getDefaultLibraryView() {
        return defaultLibraryView;
    }

    public void setDefaultLibraryView(String defaultLibraryView) {
        this.defaultLibraryView = defaultLibraryView;
    }
}
