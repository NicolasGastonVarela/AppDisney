package com.AppDisney.AppDisney.Model;

import javax.persistence.*;

@Entity(name = "moviecharacters")
@Table(name = "movieCharacter", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class MovieCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String image;

    private String name;

    private int age;

    private int weight;

    private String history;

    private String relatedMovies;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getRelatedMovies() {
        return relatedMovies;
    }

    public void setRelatedMovies(String relatedMovies) {
        this.relatedMovies = relatedMovies;
    }

    public MovieCharacter() {
    }

    public MovieCharacter(long id, String image, String name, int age, int weight, String history, String relatedMovies) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.history = history;
        this.relatedMovies = relatedMovies;
    }
}
