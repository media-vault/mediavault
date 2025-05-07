package com.mediavault.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "mediaType",
    visible = true
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Movie.class, name = "MOVIE")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "media_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "media")
public abstract class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String filePath;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    private boolean isAvailable;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_media")
    private MediaType mediaType;

    public Media() {}

    public Media(Long id, String title, String filePath, LocalDate releaseDate, LocalDateTime createdAt, LocalDateTime updatedAt, boolean isAvailable, MediaType mediaType) {
        this.id = id;
        this.title = title;
        this.filePath = filePath;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isAvailable = isAvailable;
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }
}
