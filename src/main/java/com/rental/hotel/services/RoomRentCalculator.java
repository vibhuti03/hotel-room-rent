package com.rental.hotel.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RoomRentCalculator {
    Map<String, Double> roomTypeRent = new HashMap<String, Double>();

    RoomRentCalculator() {
        roomTypeRent.put("Suite", 300.0);
        roomTypeRent.put("Single", 100.10);
        roomTypeRent.put("Double", 200.40);
    }

    public double getRoomRentByRoomType(String roomType, int numberOfDays){
        try {
            double rentPerDay = roomTypeRent.get(roomType);

            return numberOfDays * rentPerDay;
        }
        catch (Exception e){
            System.out.println(e);
            return 150.0;
        }
    }

}
