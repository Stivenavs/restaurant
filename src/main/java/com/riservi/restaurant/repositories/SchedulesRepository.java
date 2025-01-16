package com.riservi.restaurant.repositories;

import com.riservi.restaurant.entities.SchedulesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface SchedulesRepository extends JpaRepository<SchedulesEntity, Integer> {
    List<SchedulesEntity> findByHour(LocalTime hour);
    List<SchedulesEntity> findByRestaurant_Id(Integer restaurantId);


}

