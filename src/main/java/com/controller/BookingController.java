package com.controller;


import com.hibernate.Dao.BookingDao;
import com.hibernate.Entity.Booking;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private static BookingDao obj = new BookingDao();

    @PostMapping("/add")
    public String addBooking(
            @RequestParam ("travel_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date travel_date,
            @RequestParam int uid,
            @RequestParam int busid)
    {
            int flag = obj.addBookingDetails(travel_date , uid , busid);
            if (flag == 0)
                return "Booking added Successfully";
            else
                return "No seat available";
    }

    @GetMapping("/{id}")
    public Booking BookingWithId(@PathVariable int id){
        Booking booking = obj.getBookingWithId(id);
        return booking;
    }
}
