package com.project.disney.repository;

import com.project.disney.model.Character;
import com.project.disney.model.MovieSerieList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMovieSerieListRepository extends CrudRepository<MovieSerieList,Integer> {


}
