package com.project.disney.repository;

import com.project.disney.model.Character;
import com.project.disney.model.MovieSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IMovieSerieRepository extends JpaRepository<MovieSerie,Integer> {
    @Query(
            value = "SELECT * FROM movie_serie as m where m.title LIKE %:name%", nativeQuery = true)
    MovieSerie findMovieSerieByName(@Param("name") String name);

    @Query(
            value = "select ms.* \n" +
                    "from gender_movie_serie as gm\n" +
                    "left join movie_serie as ms \n" +
                    "on gm.id_movie_serie = ms.idmovie_serie\n" +
                    "where id_gender= :idGender", nativeQuery = true)
    List<MovieSerie> findMovieSerieByIdGender(@Param("idGender") String idGender);

}
