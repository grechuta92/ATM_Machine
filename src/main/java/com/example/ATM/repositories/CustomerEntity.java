package com.example.ATM.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String gender;
    private Long phoneNumber;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private AccountEntity account;
    @OneToOne(cascade = CascadeType.ALL)
    private AddressEntity address;
    @OneToOne(cascade = CascadeType.ALL)
    private PinNumberEntity pinNumber;



}
