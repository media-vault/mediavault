package com.mediavault.dto;

public class UserPreferencesDTO {
    private Long id;
    private boolean darkMode = false;
    private String defaultLibraryView; 

    public UserPreferencesDTO() {}

    public UserPreferencesDTO(Long id, boolean darkMode, String defaultLibraryView) {
        this.id = id;
        this.darkMode = darkMode;
        this.defaultLibraryView = defaultLibraryView;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
