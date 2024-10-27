package com.rental.hotel.controllers;

import com.rental.hotel.models.CustomerInformationEntity;
import com.rental.hotel.models.HotelRoomEntity;
import com.rental.hotel.models.RentalInformationEntity;
import com.rental.hotel.repositories.CustomerInformationRepository;
import com.rental.hotel.repositories.HotelRoomRepository;
import com.rental.hotel.repositories.RentalInformationRepository;
import com.rental.hotel.services.RoomAssignmentService;
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

    @Autowired
    private RoomAssignmentService roomAssignmentService;

    @Autowired
    private CustomerInformationRepository customerInformationRepository;

    @Autowired
    private RentalInformationRepository rentalInformationRepository;

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
    public String rentRoom(@RequestParam String roomType,
                           @RequestParam Long customerId,
                           @RequestParam String customerName,
                           @RequestParam String phoneNumber,
                           @RequestParam int numberOfDays){

        CustomerInformationEntity customerInformation =CustomerInformationEntity.builder()
                                                                            .id(customerId)
                                                                            .name(customerName)
                                                                            .phoneNumber(phoneNumber)
                                                                            .build();
        customerInformationRepository.save(customerInformation);

        HotelRoomEntity roomAssigned = roomAssignmentService.getRoomDetails(roomType);
        double roomRent = roomRentCalculator.getRoomRentByRoomType(roomType, numberOfDays);

        roomAssigned.setRoomAvailability(false);
        hotelRoomRepository.save(roomAssigned);

        RentalInformationEntity rentalInformation = RentalInformationEntity.builder()
                .customerId(customerInformation)
                .roomId(roomAssigned)
                .build();

        rentalInformationRepository.save(rentalInformation);

        return "Room Number: " + roomAssigned.getRoomId() +
                "\nRoom Type: " + roomAssigned.getRoomType() +
                "\nRoom Rent: " +roomRent;
    }

}
