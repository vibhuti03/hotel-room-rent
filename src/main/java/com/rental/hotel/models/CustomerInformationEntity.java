package com.rental.hotel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Table(name="customer-information")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInformationEntity {

    @Id
    private Long id;

    private String name;

    private String phoneNumber;

    @OneToOne(mappedBy = "customerId")
    private RentalInformationEntity rentalInformationEntity;
}
