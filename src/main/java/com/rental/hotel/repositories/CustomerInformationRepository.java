package com.rental.hotel.repositories;

import com.rental.hotel.models.CustomerInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInformationRepository extends JpaRepository<CustomerInformationEntity, Long> {
}
