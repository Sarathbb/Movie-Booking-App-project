package com.apktl.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "date_time_table")
public class CurrentDateDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "Movie_date")
	private String date;
	
	@Column(name = "Movie_time")
	private String time;
	
	@OneToMany(mappedBy = "operation", fetch = FetchType.EAGER)
	private List<Seat> seat;
	
	public CurrentDateDTO() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<Seat> getSeat() {
		return seat;
	}

	public void setSeat(List<Seat> seat) {
		this.seat = seat;
	}

	public CurrentDateDTO(int id, String date, String time, List<Seat> seat) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "CurrentDateDTO [id=" + id + ", date=" + date + ", time=" + time + ", seat=" + seat + "]";
	}
	
	

	
	
	
}
