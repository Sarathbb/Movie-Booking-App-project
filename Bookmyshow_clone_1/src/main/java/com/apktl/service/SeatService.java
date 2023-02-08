package com.apktl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apktl.model.CurrentDateDTO;
import com.apktl.model.CustomerDTO;
import com.apktl.model.Seat;
import com.apktl.repository.SeatRepository;

@Service
public class SeatService {

	@Autowired
	private SeatRepository sRepo;
	
	public int saveSeat(Seat seat,CustomerDTO cdto,String date,String time)
	{
		List<Seat> list = new ArrayList<Seat>();
		list.add(seat);
		cdto.setSeat(list);
		CurrentDateDTO cdDTO = new CurrentDateDTO();
		cdDTO.setDate(date);
		cdDTO.setTime(time);
		cdDTO.setSeat(list);
		
		seat.setOperation(cdDTO);
		seat.setCustomer(cdto);
		
		Seat save = sRepo.save(seat);
		
		return 1;
	}
	
	public List<Seat> getSeats(int id){
		List<Seat> list = sRepo.getAllSeat(id);
		return list;
	}
	
	public List<Seat> getAllSeat(String date, String time){
		List<Seat> list = sRepo.getAllByDate(date, time);
		return list;
	}
	
	/*
	 * public List<String> checkBookingSeats(String date,String time) { List<String>
	 * seatNo1 = new ArrayList<String>(); List<Seat> all =
	 * sRepo.getAllByDate(date,time);
	 * 
	 * for (Seat s : all) { for (String s1 : s.getSeatNo()) { seatNo1.add(s1); }
	 * 
	 * } return seatNo1; }
	 */
}




