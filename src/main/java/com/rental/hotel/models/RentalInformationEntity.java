package com.rental.hotel.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="rental-information")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class RentalInformationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private CustomerInformationEntity customerId;

    @OneToOne
    @JoinColumn(name = "hotel_room_id", referencedColumnName = "roomId")
    private HotelRoomEntity roomId;
}
