package com.example.ATM.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PinNumberResource {

    @NonNull
    private Long id;
    @NonNull
    private int pin;

}
