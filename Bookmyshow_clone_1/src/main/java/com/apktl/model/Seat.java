package com.apktl.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Seat 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_id")
	private long sId;
	
	@ElementCollection
	private List<String> seatNo;
	
	@Column(name="total")
	private double total;
	
	@ManyToOne
	private CustomerDTO customer;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private CurrentDateDTO operation;

	public Seat() {
		
	}

	public long getsId() {
		return sId;
	}

	public void setsId(long sId) {
		this.sId = sId;
	}

	public List<String> getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(List<String> seatNo) {
		this.seatNo = seatNo;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public CurrentDateDTO getOperation() {
		return operation;
	}

	public void setOperation(CurrentDateDTO operation) {
		this.operation = operation;
	}

	public Seat(long sId, List<String> seatNo, double total, CustomerDTO customer, CurrentDateDTO operation) {
		super();
		this.sId = sId;
		this.seatNo = seatNo;
		this.total = total;
		this.customer = customer;
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "Seat [sId=" + sId + ", total=" + total + ", customer=" + customer
				+ ", operation=" + operation + "]";
	}
	
	
}
