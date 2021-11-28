package com.project.disney.controller;


import com.project.disney.model.CharacterList;
import com.project.disney.repository.ICharacterListRepository;
import com.project.disney.repository.ICharacterRepository;
import com.project.disney.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.disney.model.Character;

import java.util.List;

@RestController
@RequestMapping(path = "/disney")
public class CharacterController {

    @Autowired
    private ICharacterService characterService;

    @Autowired
    private ICharacterListRepository characterListRepository;

    private List<Character> characterList = null;

    @GetMapping(path = "/characters")
    @ResponseBody
    ResponseEntity<CharacterList> getAllCharacters(@RequestParam(value = "name", required = false) String name,
                                                   @RequestParam(value = "age", required = false) String age,
                                                   @RequestParam(value = "movies", required = false) String idMovieSerie) {
        if (name != null) {
            try {
                characterList = characterService.findCharacterByName(name);
                if (!characterList.isEmpty()) {
                    return new ResponseEntity(characterList, HttpStatus.OK);
                }
                return new ResponseEntity("No existe personaje con ese nombre", HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else if (age !=null) {
            try {
                characterList = characterService.findCharacterByAge(age);
                if (!characterList.isEmpty()) {
                    return new ResponseEntity(characterList, HttpStatus.OK);
                }
                return new ResponseEntity("No existe personaje con edad de " + age, HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else if (idMovieSerie != null) {
            try {
                characterList = characterService.findCharacterByIdMovie(idMovieSerie);
                if (!characterList.isEmpty()) {
                    return new ResponseEntity(characterList, HttpStatus.OK);
                }
                return new ResponseEntity("No existe personaje con el id de pelicula/serie:  " + idMovieSerie, HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }
        Iterable<CharacterList> characterList1 = characterListRepository.findAll();
        return new ResponseEntity(characterList1, HttpStatus.OK);

    }

}


