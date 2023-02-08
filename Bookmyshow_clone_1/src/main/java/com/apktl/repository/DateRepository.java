package com.apktl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apktl.model.CurrentDateDTO;

@Repository
public interface DateRepository extends CrudRepository<CurrentDateDTO, Integer>{

}
