package com.riservi.restaurant.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDomain {
    private int id;
    private LocalDate date;
    private LocalTime time;
    private int tableNumber;
    private int customerId;
    private int restaurantId;
}

