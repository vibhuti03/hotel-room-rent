package com.rental.hotel.repositories;

import com.rental.hotel.models.HotelRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRoomRepository extends JpaRepository<HotelRoomEntity, Long> {
    List<HotelRoomEntity> findByRoomAvailabilityTrue();
    /*
    By naming the method findByRoomAvailabilityTrue,
    Spring Data JPA understands that you want to query -
                "all Room entities where roomAvailability is true."
     */

    @Query("SELECT r.roomRentPerDay FROM HotelRoomEntity r WHERE r.roomId = :roomId")
    Integer findRoomRentPerDayByRoomId(Long roomId);
}
