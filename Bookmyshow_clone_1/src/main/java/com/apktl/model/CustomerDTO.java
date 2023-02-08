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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_table")
public class CustomerDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "customer_name",length = 200,nullable = false)
	private String name;
	
	@Column(name = "customer_email",length = 200,nullable = false,unique = true)
	private String email;
	
	@Column(name = "customer_password",length = 15,nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private List<Seat> seat;
	
	@OneToOne(mappedBy = "customer", fetch = FetchType.EAGER)
	private TicketBookingDTO tHistory;
	
	public CustomerDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Seat> getSeat() {
		return seat;
	}

	public void setSeat(List<Seat> seat) {
		this.seat = seat;
	}

	public TicketBookingDTO gettHistory() {
		return tHistory;
	}

	public void settHistory(TicketBookingDTO tHistory) {
		this.tHistory = tHistory;
	}

	public CustomerDTO(int id, String name, String email, String password, List<Seat> seat, TicketBookingDTO tHistory) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.seat = seat;
		this.tHistory = tHistory;
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", tHistory=" + tHistory + "]";
	}

	
	
}
