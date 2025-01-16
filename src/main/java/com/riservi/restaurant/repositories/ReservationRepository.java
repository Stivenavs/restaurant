package com.riservi.restaurant.repositories;

import com.riservi.restaurant.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {
    List<ReservationEntity> findByDate(LocalDate date);
    List<ReservationEntity> findByCustomer_Id(int customerId);
    List<ReservationEntity> findByRestaurant_Id(int restaurantId);
}

