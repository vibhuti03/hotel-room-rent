package com.rental.hotel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hotel-room")
@Getter
@Setter
public class HotelRoomEntity {

    @Id
    private Long roomId;

    private int roomRentPerDay;

    private boolean roomAvailability;

}
