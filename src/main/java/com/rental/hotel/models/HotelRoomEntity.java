package com.rental.hotel.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hotel-room")
@Getter
@Setter
public class HotelRoomEntity {

    @Id
    private Long roomId;

    private String roomType;

    private boolean roomAvailability;

    @OneToOne(mappedBy = "roomId")
    private RentalInformationEntity rentalInformationEntity;

}
