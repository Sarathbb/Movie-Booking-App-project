package com.apktl.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apktl.model.CustomerDTO;
import com.apktl.model.Seat;
import com.apktl.model.TicketBookingDTO;
import com.apktl.repository.TicketBookingRepository;

@Service
public class TicketBookingService {

	@Autowired
	private TicketBookingRepository repo;
	
	public TicketBookingDTO saveBookingData(TicketBookingDTO tdto,CustomerDTO object) {
		
		//object.settHistory(tdto);
		tdto.setCustomer(object);
		TicketBookingDTO save = repo.save(tdto);
		return save;
	}
	
	public List<TicketBookingDTO> getAllHistory(int id){
		List<TicketBookingDTO> list = repo.getAllHistory(id);		
		return list;
	}
	
	public List<String> checkBookingSeats(String mName,String date,String time)
	{
		List<String> seatNo1 = new ArrayList<String>();
		List<TicketBookingDTO> all = repo.checkSeatHistory(mName, date, time);

		for (TicketBookingDTO s : all) {
			for (String s1 : s.getSeatNo()) {
				seatNo1.add(s1);
			}

		}
		return seatNo1;
	}
	
}
