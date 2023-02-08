package com.apktl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apktl.model.CurrentDateDTO;
import com.apktl.repository.DateRepository;

@Service
public class DateService {
	
	@Autowired
	private DateRepository repo;
	
	public void saveDateTime(CurrentDateDTO cdate) {
		
		//repo.save(cdate);
	}

}
