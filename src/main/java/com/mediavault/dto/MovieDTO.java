package com.mediavault.dto;

public class MovieDTO extends MediaDTO {
    private int duration;
    private String director;

    public MovieDTO() {}

    public MovieDTO(int duration, String director) {
        this.duration = duration;
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

}
