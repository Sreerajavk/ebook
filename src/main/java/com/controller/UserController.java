package com.controller;

import java.time.LocalDate;
import java.util.*;

import com.hibernate.Entity.Booking;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hibernate.Dao.*;
import com.hibernate.Entity.Users;

@RestController
@RequestMapping("/users")
public class UserController {

	private static UserDao obj = new UserDao();

	@GetMapping("all")
	public ResponseEntity<List<Users>> allUsers(){

        ResponseEntity<List<Users>> response = new ResponseEntity<List<Users>>(HttpStatus.OK);
		List<Users> userList = obj.allUsers();
		return response.ok().body(userList);
	}

	@GetMapping("/{id}")
	public Users userWithId(@PathVariable String id) {
		Users user = obj.userWithId(Integer.parseInt(id));
		System.out.println(user);
		if ( user == null)
			return new Users();
		return user;
	}

    @PostMapping("/add")
    public String addBus(
            @RequestParam String name ,
            @RequestParam String email,
            @RequestParam String mobile,
			@RequestParam int id
    ){
        Users user  = new Users(id , name , email , mobile );
        obj.creteUser(user);
        return "User added Succesfully";
    }

	@GetMapping("/booking")
	public Set<Booking> getBooking(@RequestParam String id , @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
	    System.out.println(date);
	    System.out.println(id);
		Users user = obj.getUserPastBooking(Integer.parseInt(id) , date);
		System.out.println(user.getBooking());
		Set<Booking> bookings = user.getBooking();
		return bookings;
	}

}
