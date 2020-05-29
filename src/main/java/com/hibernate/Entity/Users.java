 package com.hibernate.Entity;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="users")
@FilterDef(name = "dateFilter" , parameters = {
		@ParamDef( name = "today" , type = "LocalDate")
})
public class Users {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uid")
	private int uid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobile")
	private String mobile; 
	
	 @OneToMany(
	            cascade = CascadeType.ALL,
	            mappedBy = "users",
	            orphanRemoval = true
	    )
	 @Filter(name = "dateFilter" , condition = " travel_date < :today")
//	 @Transient
	 private Set<Booking> booking;
	 
	 public Users() {}
	 

	public Users(int id , String name, String email, String mobile) {
		super();
		this.uid = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}


	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Set<Booking> getBooking() {
		return booking;
	}

	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}

}
