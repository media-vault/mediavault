package com.mediavault.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.*;
import lombok.*;

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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String filePath;
    private String coverArtUrl;
    private String genre;
    private int releaseYear;
    private String language;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_media")
    private MediaType mediaType;
}
