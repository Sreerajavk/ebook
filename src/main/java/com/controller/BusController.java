package com.controller;


import com.hibernate.Dao.BusDao;
import com.hibernate.Entity.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/bus")
public class BusController {

    private static BusDao obj = new BusDao();

    @GetMapping("/all")
    public List<Bus> AllBusInfo(){
        List<Bus> busList= obj.allBus();
        return busList;
    }

    @GetMapping("/{id}")
    public Bus BusWithId(@PathVariable String id){

        Bus bus = obj.getBusWithId(Integer.parseInt(id));
        return bus;
    }
    @GetMapping("/search")
    public List<Bus> BusWithOrigin(@RequestParam String origin , @RequestParam String destination){
        List<Bus> busList = obj.getBusWithOrigin(origin , destination);
        return busList;
    }
    @PostMapping("/add")
    public String addBus(
            @RequestParam String name ,
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam String classType,
            @RequestParam int totalseats,
            @RequestParam int amount
    ){
        Bus bus = new Bus(name , origin , destination , classType , totalseats , amount);
        obj.createBus(bus);
        return "Bus added Succesfully";
    }

    @GetMapping("/types")
    public List<Bus> busWithType(@RequestParam String classType){
        List<Bus> busList = obj.getBusWithType(classType);
        return busList;
    }

    @GetMapping("/edit/fair")
    public String editAmount(@RequestParam int busId , @RequestParam() int amount ){
        obj.editTravelAmount(busId , amount);
        return "Travel amount updated Successfully";
    }

}


