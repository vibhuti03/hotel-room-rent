package com.rental.hotel.services;

import org.springframework.stereotype.Service;

@Service
public class RoomRentCalculator {

    public int getRoomRent(int days, int rentPerDay){
        return days*rentPerDay;
    }
}
