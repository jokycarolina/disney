package com.project.disney.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.disney.model.MovieSerie;
import java.util.Set;

@Entity
@Table(name="character_")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_character")
    private Integer idCharacter;

    private String image;

    @Column(name="full_name")
    private String fullName;

    private double weight;

    private int age;

    private String story;


    @JsonBackReference
    @ManyToMany(mappedBy = "characterSet")
    private Set<MovieSerie> movieSerieSet;

    public int getIdCharacter() {
        return idCharacter;
    }

    public Character() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Set<MovieSerie> getMovieSerieSet() {
        return movieSerieSet;
    }

    public void setMovieSerieSet(Set<MovieSerie> movieSerieSet) {
        this.movieSerieSet = movieSerieSet;
    }

    public void setIdCharacter(Integer idCharacter) {
        this.idCharacter = idCharacter;
    }

    @Override
    public String toString() {
        return "Character{" +
                "idCharacter=" + idCharacter +
                ", image=" + image +
                ", fullName='" + fullName + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", story='" + story + '\'' +
                '}';
    }


}
