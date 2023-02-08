package com.apktl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.apktl.model.TicketBookingDTO;

@Repository
public interface TicketBookingRepository extends JpaRepository<TicketBookingDTO, Integer>{

	@Query(value = "select * from ticket_booking_history where customer_id=? ORDER BY bookingid DESC", nativeQuery = true)
	public List<TicketBookingDTO> getAllHistory(int id);
	
	@Query(value = "SELECT * FROM ticket_booking_history "
			     + "where movie_name=? and movie_date=? "
			     + "and movie_time=?",nativeQuery = true)
	public List<TicketBookingDTO> checkSeatHistory(String mName,String date,String time);
	
}
