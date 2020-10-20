package com.example.ATM.resources;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResource {

    @NotNull
    private Long cardNumber;
    @NotBlank
    private double balance;

    @NotNull
    @NotBlank
    private int pinNumber;

    private int getPinNumber() {
        return pinNumber;
    }

    private void setPinNumber(final int pinNumber) {
        this.pinNumber = pinNumber;
    }
}
