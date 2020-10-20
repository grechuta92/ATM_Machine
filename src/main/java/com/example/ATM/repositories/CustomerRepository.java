package com.example.ATM.repositories;

import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {

    CustomerEntity findByName(String name);


    CustomerEntity findByAccountCardNumber(long cardNumber);
}
