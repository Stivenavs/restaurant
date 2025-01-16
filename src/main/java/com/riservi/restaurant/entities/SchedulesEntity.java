package com.riservi.restaurant.entities;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "SCHEDULES")
public class SchedulesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "hour", nullable = false, length = 255)
    private LocalTime hour;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private RestaurantEntity restaurant;
}
