package com.AppDisney.AppDisney.DTO;

public class MovieDTO {

    private long id;
    private String image;
    private String title;
    private int creationDate;
    private int calification;
    private String relatedCharacters;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(int creationDate) {
        this.creationDate = creationDate;
    }

    public int getCalification() {
        return calification;
    }

    public void setCalification(int calification) {
        this.calification = calification;
    }

    public String getRelatedCharacters() {
        return relatedCharacters;
    }

    public void setRelatedCharacters(String relatedCharacters) {
        this.relatedCharacters = relatedCharacters;
    }

    public MovieDTO() {
    }

    public MovieDTO(long id, String image, String title, int creationDate, int calification, String relatedCharacters) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.creationDate = creationDate;
        this.calification = calification;
        this.relatedCharacters = relatedCharacters;
    }
}
