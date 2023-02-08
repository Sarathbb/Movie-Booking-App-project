package com.apktl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apktl.model.MoviesDTO;

@Repository
public interface MoviesRepository extends CrudRepository<MoviesDTO, Integer>{

}
