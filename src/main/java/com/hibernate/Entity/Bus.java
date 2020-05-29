package com.hibernate.Entity;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bus")
@FilterDef(name = "seatFilter" , parameters = {@ParamDef(name = "t_date" , type = "LocalDate")})

public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bus_id")
	private int busId;
	
	@Column(name = "bus_name")
	private String busName;
	
	@Column(name = "origin")
	private String origin;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "bus_type")
	private String classType;
	
	@Column(name = "total_seats")
	private int totalSeats;
	
	@Column(name = "amount")
	private int amount;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			mappedBy = "bus"
			
			)
	@Filter(name = "seatFilter" , condition = ":t_date = travel_date")
	private Set<SeatInfo> seatInfo;
	
	@OneToMany(
			mappedBy = "bus",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private Set<Booking> booking;
	
	public Bus() {}

	public Bus(String busName, String origin, String destination, String classType, int totalSeats, int amount)
	{
		super();
		this.busName = busName;
		this.origin = origin;
		this.destination = destination;
		this.classType = classType;
		this.totalSeats = totalSeats;
		this.amount = amount;
//		this.seatInfo = seatInfo;
//		this.booking = booking;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Set<SeatInfo> getSeatInfo() {
		return seatInfo;
	}

	public void setSeatInfo(Set<SeatInfo> seatInfo) {
		this.seatInfo = seatInfo;
	}

//	public Set<Booking> getBooking() {
//		return booking;
//	}

	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}	
}
