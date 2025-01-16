package com.riservi.restaurant.controllers.dto.out;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationOutDTO {
    public int id;
    public LocalDate date;
    public LocalTime time;
    public int tableNumber;
    public int customerId;
    public int restaurantId;
}

