package com.project.disney.repository;

import com.project.disney.model.Gender;
import org.springframework.data.repository.CrudRepository;

public interface IGenderRepository extends CrudRepository<Gender,Integer> {
}
