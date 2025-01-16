package com.riservi.restaurant.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "RESERVATIONS")
@Getter
@Setter
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date", nullable = false, length = 255)
    private LocalDate date;

    @Column(name = "time", nullable = false, length = 255)
    private LocalTime time;

    @Column(name = "table_number", nullable = false, length = 255)
    private int tableNumber;

    @Column(name = "status", nullable = false, length = 255)
    String status;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private RestaurantEntity restaurant;

}
