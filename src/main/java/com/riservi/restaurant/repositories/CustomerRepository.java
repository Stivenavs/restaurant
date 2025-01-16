package com.riservi.restaurant.repositories;

import com.riservi.restaurant.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    List<CustomerEntity> findByFirstName(String firstName);
    List<CustomerEntity> findByLastName(String lastName);
    CustomerEntity findByDocument(String document);
}
