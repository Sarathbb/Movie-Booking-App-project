package com.apktl.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ticket_booking_history")
public class TicketBookingDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingID;
	
	private String movieName;
	
	private String bookingDate;
	
	@ElementCollection
	private List<String> seatNo;
	
	private double totalPrice;
	
	private String movieDate;
	
	private String movieTime;
	
	@OneToOne
	private CustomerDTO customer;
	
	public TicketBookingDTO() {
		
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public List<String> getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(List<String> seatNo) {
		this.seatNo = seatNo;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public String getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}

	public String getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}

	public TicketBookingDTO(int bookingID, String movieName, String bookingDate, List<String> seatNo, double totalPrice,
			String movieDate, String movieTime, CustomerDTO customer) {
		super();
		this.bookingID = bookingID;
		this.movieName = movieName;
		this.bookingDate = bookingDate;
		this.seatNo = seatNo;
		this.totalPrice = totalPrice;
		this.movieDate = movieDate;
		this.movieTime = movieTime;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "TicketBookingDTO [bookingID=" + bookingID + ", movieName=" + movieName + ", bookingDate=" + bookingDate
				+ ", totalPrice=" + totalPrice + ", movieDate=" + movieDate + ", movieTime="
				+ movieTime + "]";
	}
	
	

	
}
