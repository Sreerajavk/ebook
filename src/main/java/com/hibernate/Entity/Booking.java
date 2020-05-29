package com.hibernate.Entity;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int bookId;
	
	@Column(name = "book_date")
	private Date bookDate;
	
	@Column(name = "travel_date")
	private Date travelDate;
	
	@Column(name = "seat_num")
	private int seatNo;
	
	@ManyToOne()
	@JoinColumn(name = "u_id")
//	@Filter(name = "myFilter")
	private Users users;
	
	@ManyToOne()
	@JoinColumn(name = "bus_id")
	private Bus bus;
	
	public Booking() {}

	public Booking(Date bookDate, Date travelDate, int seatNo, Users users, Bus bus) {
		super();
		this.bookDate = bookDate;
		this.travelDate = travelDate;
		this.seatNo = seatNo;
		this.users = users;
		this.bus = bus;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

//	public Users getUsers() {
//		return users;
//	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	
	

}
