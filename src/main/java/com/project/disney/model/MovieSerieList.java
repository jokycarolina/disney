package com.project.disney.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="movie_serie")
public class MovieSerieList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmovie_serie")
    @JsonIgnore
    private Integer idMovieSerie;

    private String image;

    private String title;

    @Column(name="creation_date")
    private Date creationDate;


    public Integer getIdMovieSerie() {
        return idMovieSerie;
    }

    public void setIdMovieSerie(Integer idMovieSerie) {
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

    @Override
    public String toString() {
        return "MovieSerieList{" +
                "idMovieSerie=" + idMovieSerie +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }


}
