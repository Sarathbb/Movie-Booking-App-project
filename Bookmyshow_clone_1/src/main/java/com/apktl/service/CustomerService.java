package com.apktl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apktl.model.CustomerDTO;
import com.apktl.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	public void addCustomer(CustomerDTO cdto) {
		repo.save(cdto);
	}
	public CustomerDTO findByEmail(String mail) {
		CustomerDTO cDto = repo.findByEmail(mail);
		
		return cDto;
	}
	public CustomerDTO findById(int id) {
		CustomerDTO cDto = repo.findById(id);
		
		return cDto;
	}
	
	public List<CustomerDTO> getAll(){
		List<CustomerDTO> findAll = repo.findAll();
		return findAll;
	}
}
