package com.AppDisney.AppDisney.DTO;

public class GenreDTO {

    private long id;
    private String name;
    private String image;
    private String relatedMovies;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRelatedMovies() {
        return relatedMovies;
    }

    public void setRelatedMovies(String relatedMovies) {
        this.relatedMovies = relatedMovies;
    }

    public GenreDTO() {
    }

    public GenreDTO(long id, String name, String image, String relatedMovies) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.relatedMovies = relatedMovies;
    }
}
