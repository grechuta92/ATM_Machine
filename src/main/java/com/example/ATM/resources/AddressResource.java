package com.example.ATM.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResource {

    @NotNull
    private Long id;
    @NotBlank
    private String street;
    @NotNull
    private int numberStreet;
    @NotBlank
    private String city;
    @NotBlank
    private String country;

}
