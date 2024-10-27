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
    public List<HotelRoomEntity> getRoomsAvailable(){
        List<HotelRoomEntity> rooms = hotelRoomRepository.findByRoomAvailabilityTrue();
        return rooms;
    }

    @PostMapping("/room-rent")
    public String rentRoom(@RequestParam int roomId){
        int rentPerDay = hotelRoomRepository.findRoomRentPerDayByRoomId((long) roomId);
        return String.valueOf(roomRentCalculator.getRoomRent(2, rentPerDay));
    }

}
