package com.rental.hotel.services;

import com.rental.hotel.models.HotelRoomEntity;
import com.rental.hotel.repositories.HotelRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomAssignmentService {

    @Autowired
    private HotelRoomRepository hotelRoomRepository;

    public HotelRoomEntity getRoomDetails(String roomType){

       Optional<HotelRoomEntity> availableRoom = hotelRoomRepository
                                                    .findFirstByRoomAvailabilityTrueAndRoomType(roomType);

       return availableRoom.get();

    }
}
