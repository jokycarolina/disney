package com.project.disney.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.project.disney.model.Character;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICharacterRepository extends CrudRepository<Character,Integer> {
    @Query(
            value = "SELECT * FROM character_ as c where c.full_name LIKE %:name%", nativeQuery = true)
    List<Character> findCharacterByName(@Param("name") String name);

    @Query(
            value = "SELECT * FROM character_ as c where c.age = :age", nativeQuery = true)
    List<Character> findCharacterByAge(@Param("age") String age);

    @Query(
            value = "select c.*\n" +
                    "from character_movie_serie as m\n" +
                    "left join character_ as c \n" +
                    "on m.id_character = c.id_character\n" +
                    "where m.id_movie_serie= :idMovieSerie", nativeQuery = true)
    List<Character> findCharacterByIdMovie(@Param("idMovieSerie") String idMovieSerie);
}

