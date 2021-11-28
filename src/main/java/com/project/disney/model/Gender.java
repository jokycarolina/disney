package com.project.disney.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_gender")
    private int idGender;

    private String name;

    private String image;

    @JsonBackReference
    @ManyToMany(mappedBy = "characterSet")
    private Set<MovieSerie> genderSet;

    public int getIdGender() {
        return idGender;
    }

    public void setId(int idGender) {
        this.idGender = idGender;
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

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    public Set<MovieSerie> getGenderSet() {
        return genderSet;
    }

    public void setGenderSet(Set<MovieSerie> genderSet) {
        this.genderSet = genderSet;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "id=" + idGender +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
