package com.riservi.restaurant.services;

import com.riservi.restaurant.entities.CustomerEntity;
import com.riservi.restaurant.entities.ReservationEntity;
import com.riservi.restaurant.entities.RestaurantEntity;
import com.riservi.restaurant.entities.mappers.ReservationEntityMapper;
import com.riservi.restaurant.models.ReservationDomain;
import com.riservi.restaurant.repositories.CustomerRepository;
import com.riservi.restaurant.repositories.ReservationRepository;
import com.riservi.restaurant.repositories.RestaurantRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ReservationService {

    private ReservationRepository reservationRepository;

    private CustomerRepository customerRepository;

    private RestaurantRepository restaurantRepository;

    private ReservationEntityMapper reservationEntityMapper;

    public ReservationDomain createReservation(ReservationDomain reservationDomain) throws Exception {

        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(reservationDomain.getCustomerId());
        Optional<RestaurantEntity> optionalRestaurant = restaurantRepository.findById(reservationDomain.getRestaurantId());

        ReservationEntity reservationEntity = reservationEntityMapper.toEntity(reservationDomain);

        if(optionalCustomer.isEmpty()){
            throw new Exception("Customer doesn't exists");
        }

        if(optionalRestaurant.isEmpty()){
            throw new Exception("Restaurant doesn't exists");
        }

        reservationEntity.setCustomer(optionalCustomer.get());
        reservationEntity.setRestaurant(optionalRestaurant.get());

        ReservationEntity savedEntity = reservationRepository.save(reservationEntity);
        return reservationEntityMapper.toDomain(savedEntity);
    }

    public ReservationDomain getReservation(int id) throws Exception {
        Optional<ReservationEntity> optionalReservation = reservationRepository.findById(id);

        if(optionalReservation.isEmpty()){
            throw new Exception("Reservation not found");
        }

        return reservationEntityMapper.toDomain(optionalReservation.get());
    }

    public List<ReservationDomain> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(reservationEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    public ReservationDomain updateReservation(ReservationDomain reservationDomain) throws Exception {
        Optional<ReservationEntity> optionalReservation = reservationRepository.findById(reservationDomain.getId());

        if(optionalReservation.isEmpty()){
            throw new Exception("Reservation not found");
        }

        ReservationEntity reservationEntity = optionalReservation.get();

        reservationEntity.setDate(reservationDomain.getDate());
        reservationEntity.setTime(reservationDomain.getTime());
        reservationEntity.setTableNumber(reservationDomain.getTableNumber());

        // Save and return the updated domain
        ReservationEntity updatedEntity = reservationRepository.save(reservationEntity);
        return reservationEntityMapper.toDomain(updatedEntity);
    }


    public List<ReservationDomain> getReservationByDate(LocalDate date) throws Exception {
        List<ReservationEntity> reservationEntityList = reservationRepository.findByDate(date);

        if(reservationEntityList.isEmpty()){
            throw new Exception("Reservation not found");
        }

        return reservationEntityList.stream()
                .map(reservationEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
