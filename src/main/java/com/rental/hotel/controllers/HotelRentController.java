package com.rental.hotel.controllers;

import com.rental.hotel.models.HotelRoomEntity;
import com.rental.hotel.repositories.HotelRoomRepository;
import com.rental.hotel.services.RoomRentCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel-rent/api/v1")
public class HotelRentController {

    @Autowired
    private HotelRoomRepository hotelRoomRepository;

    @Autowired
    private RoomRentCalculator roomRentCalculator;

    @GetMapping("/hello")
    public String hello(){
        return "Hello from Hotel Rental";
    }

    @GetMapping("/room-available")
    public Object getRoomsAvailable(){

       List<HotelRoomEntity> availableRooms = hotelRoomRepository.findByRoomAvailabilityTrue();

       if(availableRooms.size() > 0){
           return availableRooms;
       }
       return "Not available";
    }

    @PostMapping("/room-rent")
    public double rentRoom(@RequestParam String roomType,
                           @RequestParam int numberOfDays){
        return roomRentCalculator.getRoomRentByRoomType(roomType, numberOfDays);
    }

}
