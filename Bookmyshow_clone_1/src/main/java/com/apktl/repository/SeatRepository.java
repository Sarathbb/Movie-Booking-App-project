package com.apktl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apktl.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer>{

	@Query(value = "select * from seat where customer_id=?", nativeQuery = true)
	public List<Seat> getAllSeat(int id);
	
	@Query(value = "select * from seat inner join seat_seat_no"
			+ " on seat.s_id = seat_seat_no.seat_s_id"
			+ " inner join date_time_table"
			+ " on seat.operation_id = date_time_table.id"
			+ " where movie_date = ? and movie_time = ?", nativeQuery = true)
	public List<Seat> getAllByDate(String date, String time);
}
