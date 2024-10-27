package com.rental.hotel.repositories;

import com.rental.hotel.models.HotelRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRoomRepository extends JpaRepository<HotelRoomEntity,Long> {

    List<HotelRoomEntity> findByRoomAvailabilityTrue();
}
