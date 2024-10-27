package com.rental.hotel.repositories;

import com.rental.hotel.models.RentalInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalInformationRepository extends JpaRepository<RentalInformationEntity, Long> {
}
