package com.project.disney.repository;

import com.project.disney.model.CharacterList;
import org.springframework.data.repository.CrudRepository;

public interface ICharacterListRepository  extends CrudRepository<CharacterList,Integer> {
}
