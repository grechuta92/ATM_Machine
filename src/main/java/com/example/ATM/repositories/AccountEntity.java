package com.example.ATM.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "Account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity implements Serializable {

    @Id
    @Column(unique = true)
    @NotNull
    private Long cardNumber;
    private double balance;
    private int pinNumber;

}
