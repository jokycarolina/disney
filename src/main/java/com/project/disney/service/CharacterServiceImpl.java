package com.project.disney.service;

import com.project.disney.model.Character;
import com.project.disney.repository.ICharacterListRepository;
import com.project.disney.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class CharacterServiceImpl implements ICharacterService{

    @Autowired
    ICharacterRepository characterRepository;

    List<Character> characters=null;


    @Override
    public List<Character> findCharacterByName(String name) {
        try {
           characters = characterRepository.findCharacterByName(name);
        } catch (Exception e){
            e.getMessage().toString();
        }
        return characters;
    }

    @Override
    public List<Character> findCharacterByAge(String age) {
        try {
            characters = characterRepository.findCharacterByAge(age);
        } catch (Exception e){
            e.getMessage().toString();
        }
        return characters;
    }

    @Override
    public List<Character> findCharacterByIdMovie(String idMovieSerie) {
        try {
            characters = characterRepository.findCharacterByIdMovie(idMovieSerie);
        } catch (Exception e){
            e.getMessage().toString();
        }
        return characters;
    }

}
