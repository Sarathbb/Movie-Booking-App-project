package com.apktl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apktl.model.CustomerDTO;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDTO, Integer>{

	CustomerDTO findByEmail(String mail);
	CustomerDTO findById(int id);
}
