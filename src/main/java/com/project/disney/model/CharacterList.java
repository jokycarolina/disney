package com.project.disney.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
@Table(name="character_")
public class CharacterList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_character")
    @JsonIgnore
    private Integer idCharacter;

    @Column(name="full_name")
    private String fullName;

    private String image;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public Integer getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(Integer idCharacter) {
        this.idCharacter = idCharacter;
    }

    @Override
    public String toString() {
        return "CharacterList{" +
                "fullName='" + fullName + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
