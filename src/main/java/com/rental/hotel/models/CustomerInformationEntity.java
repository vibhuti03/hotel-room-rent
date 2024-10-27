package com.rental.hotel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@Entity
@Table(name="customer-information")
public class CustomerInformationEntity {

    @Id
    private Long id;

    private String name;

    private String phoneNumber;
}
