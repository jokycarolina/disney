package com.project.disney.controller;

import com.project.disney.model.Character;
import com.project.disney.model.Gender;
import com.project.disney.model.MovieSerie;
import com.project.disney.model.MovieSerieList;
import com.project.disney.repository.ICharacterRepository;
import com.project.disney.repository.IGenderRepository;
import com.project.disney.repository.IMovieSerieListRepository;
import com.project.disney.repository.IMovieSerieRepository;
import com.project.disney.service.IMovieSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/disney")
public class MovieSerieController {
    @Autowired
    private IMovieSerieRepository movieSerieRepository;

    @Autowired
    private IMovieSerieListRepository movieSerieListRepository;

    @Autowired
    private ICharacterRepository characterRepository;

    @Autowired
    private IMovieSerieService movieSerieService;

    @Autowired
     private IGenderRepository genderRepository;

    Iterable<MovieSerie> movieSerieList;

    @GetMapping(path = "/movies")
    @ResponseBody
    ResponseEntity<MovieSerieList> getAllMovieSerie(@RequestParam(value = "name", required = false) String name,
                                                    @RequestParam(value = "genre", required = false) String idGender,
                                                    @RequestParam(value = "order", required = false) String order) {
        if(name != null){
            MovieSerie movieSerie =movieSerieRepository.findMovieSerieByName(name);
            return new ResponseEntity(movieSerie,HttpStatus.OK);
        } else if(idGender!=null){
            List <MovieSerie> movieSerieList = movieSerieRepository.findMovieSerieByIdGender(idGender);
            return new ResponseEntity(movieSerieList,HttpStatus.OK);
        }else if(order!=null && order.equals("ASC" )){
            List <MovieSerie> movieSeries = movieSerieRepository.
                    findAll(Sort.by(Sort.Direction.ASC,"idMovieSerie"));
            return new ResponseEntity(movieSeries,HttpStatus.OK);
        } else if(order!=null && order.equals("DESC")){
            List <MovieSerie> movieSeries = movieSerieRepository.
                    findAll(Sort.by(Sort.Direction.DESC,"idMovieSerie"));
            return new ResponseEntity(movieSeries,HttpStatus.OK);
        }


            Iterable<MovieSerieList> movieSeries= movieSerieListRepository.findAll();
        return new ResponseEntity(movieSeries, HttpStatus.OK) ;
    }

    @GetMapping(path ="/movies/{id}")
    @ResponseBody
    ResponseEntity<MovieSerie> getMovieSerieById(@PathVariable("id") Integer idMovieSerie){
       try{
          Optional<MovieSerie> movieSerie=movieSerieRepository.findById(idMovieSerie);
          if(movieSerie.isPresent()){
              MovieSerie movieSerie1 = movieSerie.get();
              return new ResponseEntity(movieSerie1,HttpStatus.OK);
          }
          return  new ResponseEntity("No existe pelicula con el id: " +idMovieSerie,HttpStatus.BAD_REQUEST);

       }catch (Exception e){
           return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }

    @PostMapping(path = "/movies/new-movie", consumes = "application/json", produces = "application/json")
    ResponseEntity<MovieSerie> newMovieSerie (@RequestBody MovieSerie movieSerie) {
        try{
            Character character1 = new Character();
            Gender gender1 = new Gender();

            for (Character character:movieSerie.getCharacterSet()) {
               if(characterRepository.findById(character.getIdCharacter()).isPresent()){
               character1= characterRepository.findById(character.getIdCharacter()).get();
               character.setImage(character1.getImage());
               character.setFullName(character1.getFullName());
               character.setWeight(character1.getWeight());
               character.setAge(character1.getAge());
               character.setStory(character1.getStory());
               character.setIdCharacter(character1.getIdCharacter());
            }
            }
            for (Gender gender:movieSerie.getGenderSet()) {
                gender1 = genderRepository.findById(gender.getIdGender()).get();
                gender.setIdGender(gender1.getIdGender());
                gender.setImage(gender1.getImage());
                gender.setName(gender1.getName());
            }

           movieSerieRepository.save(movieSerie);
            return  new ResponseEntity(movieSerie,HttpStatus.CREATED);
        } catch (Exception e){
            System.out.println(movieSerie);
          return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping(path ="/movies/update-movie/{id}/{title}")
    @ResponseBody
    ResponseEntity<MovieSerie> updateSerieMovie(@PathVariable("id") Integer id, @PathVariable("title") String title){
    try{
        if(movieSerieRepository.findById(id).isPresent()){
            MovieSerie movieSerie = movieSerieRepository.findById(id).get();
            movieSerie.setTitle(title);
            movieSerieRepository.save(movieSerie);
            return new ResponseEntity(movieSerie,HttpStatus.OK);
        }
        return new ResponseEntity("No se encuentra una pelicula/serie con el id pasado: "+id , HttpStatus.BAD_REQUEST);
    }catch (Exception e){
        return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
    }

    @DeleteMapping(path = "/movies/delete/{id}")
    @ResponseBody
    ResponseEntity<MovieSerie> deleteMovieSerieById(@PathVariable("id") int id) {

        try {
            if (movieSerieRepository.findById(id).isPresent()) {
                movieSerieRepository.deleteById(id);
                return new ResponseEntity("Se elimino correctamente", HttpStatus.OK);
            }
            return new ResponseEntity("Hubo un error en la eliminacion", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }


}
