package com.controller;


import com.hibernate.Dao.SeatInfoDao;
import com.hibernate.Entity.Bus;
import com.hibernate.Entity.SeatInfo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("/seat")
public class SeatController {

    private  static SeatInfoDao seatInfoDao = new SeatInfoDao();

    @GetMapping("")
    public Set<SeatInfo> getSeatInfo(@RequestParam int busId , @RequestParam(value = "date",required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){

        System.out.println(date);
        Bus bus = seatInfoDao.getSeatInformation(busId , date);
        Set<SeatInfo> seats = bus.getSeatInfo();
        return seats;
    }

}
