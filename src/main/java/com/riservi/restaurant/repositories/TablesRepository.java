package com.riservi.restaurant.repositories;

import com.riservi.restaurant.entities.TablesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TablesRepository extends JpaRepository<TablesEntity, Integer> {
    List<TablesEntity> findByDescription(String description);
    List<TablesEntity> findByNumTable(int numTable);
    List<TablesEntity> findByRestaurant_Id(Integer restaurantId); // Relación con RestaurantEntity
}