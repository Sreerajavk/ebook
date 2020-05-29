package com.hibernate.Entity;

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
@Table(name = "seatinfo")
public class SeatInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "travel_date")
	private Date travelDate;
	
	@Column(name = "seat_left")
	private int seatLeft;
	
	@ManyToOne()
	@JoinColumn(name = "bus_id")
	private Bus bus;
	
	public SeatInfo() {}

	public SeatInfo(Date travelDate, int seatLeft, Bus bus) {
		super();
		this.travelDate = travelDate;
		this.seatLeft = seatLeft;
		this.bus = bus;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public int getSeatLeft() {
		return seatLeft;
	}

	public void setSeatLeft(int seatLeft) {
		this.seatLeft = seatLeft;
	}

//	public Bus getBus() {
//		return bus;
//	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	
	
	

}
