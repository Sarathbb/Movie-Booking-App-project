package com.apktl.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HistoryResponse {

	private String movieName;
	private List seatNo;
	private double seatPrice;
	private String bookingDate;
	private String showOnDate;
	private String showOnTime;
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public List getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(List seatNo) {
		this.seatNo = seatNo;
	}
	public double getSeatPrice() {
		return seatPrice;
	}
	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getShowOnDate() {
		return showOnDate;
	}
	public void setShowOnDate(String showOnDate) {
		this.showOnDate = showOnDate;
	}
	public String getShowOnTime() {
		return showOnTime;
	}
	public void setShowOnTime(String showOnTime) {
		this.showOnTime = showOnTime;
	}
	public HistoryResponse(String movieName, List seatNo, double seatPrice, String bookingDate, String showOnDate,
			String showOnTime) {
		super();
		this.movieName = movieName;
		this.seatNo = seatNo;
		this.seatPrice = seatPrice;
		this.bookingDate = bookingDate;
		this.showOnDate = showOnDate;
		this.showOnTime = showOnTime;
	}
	public HistoryResponse() {
		
	}
	@Override
	public String toString() {
		return "HistoryResponse [movieName=" + movieName + ", seatNo=" + seatNo + ", seatPrice=" + seatPrice
				+ ", bookingDate=" + bookingDate + ", showOnDate=" + showOnDate + ", showOnTime=" + showOnTime + "]";
	}
	
	
	
	
	
	
}
