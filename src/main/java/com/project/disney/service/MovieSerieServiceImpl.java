package com.project.disney.service;

import com.project.disney.model.Character;
import com.project.disney.model.Gender;
import com.project.disney.model.MovieSerie;
import com.project.disney.repository.ICharacterRepository;
import com.project.disney.repository.IGenderRepository;
import com.project.disney.repository.IMovieSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieSerieServiceImpl implements IMovieSerieService {
   @Autowired
   private IMovieSerieRepository movieSerieRepository;

   @Autowired
   private ICharacterRepository characterRepository;

   @Autowired
   private IGenderRepository genderRepository;
/*
   @Override
   public Optional <MovieSerie> saveMovie(MovieSerie movieSerie) {
      Optional<Character> characterOptional = null;
      Optional<Gender> genderOptional = null;
      Optional<MovieSerie> mov = Optional.ofNullable(movieSerie);
      //buscar en los characters que estan dentro de movieSerie como es un set hay que iterar
      try{
      characterOptional = movieSerie.getCharacterSet()
              .stream()
              .filter(character -> characterRepository.findById((character.getIdCharacter())));


      genderOptional = movieSerie.getGenderSet()
                        .stream()
                        .filter(gender -> genderRepository.existsById(gender.getIdGender()))
                        .findAny();
         System.out.println("OPTIONAALLL --> "+characterList);

      if(characterOptional.isPresent() && genderOptional.isPresent()){
         Character character1 = characterRepository.findById(characterOptional.get().getIdCharacter()).get();
         Set<Character> characterSet = new HashSet<>();
         characterSet.add(character1);

         Gender gender1 = genderRepository.findById(genderOptional.get().getIdGender()).get();
         Set<Gender> genderSet = new HashSet<>();
         genderSet.add(gender1);

         movieSerie.setCharacterSet(characterSet);
         movieSerie.setGenderSet(genderSet);

         movieSerieRepository.save(movieSerie);
      } }catch (Exception e){
         return mov;
      }
      mov = null;
       return mov;
   }*/
}
