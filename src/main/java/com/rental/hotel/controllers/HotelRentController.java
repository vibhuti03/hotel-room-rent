package com.rental.hotel.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel-rent/api/v1")
public class HotelRentController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello from Hotel Rental";
    }

    @GetMapping("/room-available")
    public String getRoomsAvailable(){
        return "Room Available";
    }

    @PostMapping("/room-rent")
    public String rentRoom(){
        return "Room Rent";
    }

}
