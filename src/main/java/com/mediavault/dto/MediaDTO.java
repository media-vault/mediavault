package com.mediavault.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "mediaType",
    visible = true
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = MovieDTO.class, name = "MOVIE")
})

public abstract class MediaDTO {
    private Long id;
    private String title;
    private String description;
    private String filePath;
    private String coverArtUrl;
    private String genre;
    private int releaseYear;
    private String language;
    private MediaTypeDTO mediaType;

    public MediaDTO() {}

    public MediaDTO(Long id, String title, String description, String filePath, String coverArtUrl, String genre, int releaseYear, String language, MediaTypeDTO mediaType) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.filePath = filePath;
        this.coverArtUrl = coverArtUrl;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.language = language;
        this.mediaType = mediaType;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getCoverArtUrl() {
        return coverArtUrl;
    }

    public void setCoverArtUrl(String coverArtUrl) {
        this.coverArtUrl = coverArtUrl;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public MediaTypeDTO getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaTypeDTO mediaType) {
        this.mediaType = mediaType;
    }

}






