package com.AppDisney.AppDisney.Model;

import javax.persistence.*;

@Entity
@Table(name = "genre", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "image",nullable = false)
    private String image;
    @Column(name = "relatedMovies",nullable = false)
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

    public Genre() {
    }

    public Genre(long id, String name, String image, String relatedMovies) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.relatedMovies = relatedMovies;
    }
}
