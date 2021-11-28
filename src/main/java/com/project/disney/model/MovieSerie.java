package com.project.disney.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name="movie_serie")
public class MovieSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmovie_serie")
    private Integer idMovieSerie;

    private String image;

    private String title;

    @Column(name="creation_date")
    private Date creationDate;

    private int score;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "character_movie_serie",
            joinColumns =  @JoinColumn(name = "id_movie_serie", referencedColumnName="idmovie_serie"),
            inverseJoinColumns = @JoinColumn(name = "id_character" ,referencedColumnName="id_character"))
    private Set<Character> characterSet;

    @JoinTable(
            name = "gender_movie_serie",
            joinColumns = @JoinColumn(name = "id_movie_serie"),
            inverseJoinColumns = @JoinColumn(name = "id_gender"))
    @ManyToMany(cascade = CascadeType.DETACH)
    private Set<Gender> genderSet;

    public int getIdMovieSerie() {
        return idMovieSerie;
    }

    public void setIdMovieSerie(int idMovieSerie) {
        this.idMovieSerie = idMovieSerie;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Set<Character> getCharacterSet() {
        return characterSet;
    }

    public void setCharacterSet(Set<Character> characterSet) {
        this.characterSet = characterSet;
    }

    public void setIdMovieSerie(Integer idMovieSerie) {
        this.idMovieSerie = idMovieSerie;
    }

    public Set<Gender> getGenderSet() {
        return genderSet;
    }

    public void setGenderSet(Set<Gender> genderSet) {
        this.genderSet = genderSet;
    }

    @Override
    public String toString() {
        return "MovieSerie{" +
                "idMovieSerie=" + idMovieSerie +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", creationDate=" + creationDate +
                ", score=" + score +
                '}';
    }
}
