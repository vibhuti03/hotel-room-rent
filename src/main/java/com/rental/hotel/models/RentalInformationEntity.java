package com.rental.hotel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rental-information")
public class RentalInformationEntity {

    @Id
    private Long id;
}
