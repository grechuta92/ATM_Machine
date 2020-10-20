package com.example.ATM.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResource {

    private Long id;
    private String name;
    private String surName;
    private int age;
    private String gender;
    private Long phoneNumber;
    private String email;
    private AccountResource account;
    private AddressResource address;
    private PinNumberResource pinNumber;

}
