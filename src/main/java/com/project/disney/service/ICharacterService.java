package com.project.disney.service;

import com.project.disney.model.Character;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ICharacterService {

    List<Character> findCharacterByName(String name);

    List<Character> findCharacterByAge(String age);

    List<Character>findCharacterByIdMovie(String idMovieSerie);
}
