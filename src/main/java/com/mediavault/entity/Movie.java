package com.mediavault.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("MOVIE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends Media {
    private int duration;
    private String director;
}
