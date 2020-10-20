package com.example.ATM.model;

import com.example.ATM.service.LuhnAlgorithm;
import com.example.ATM.service.PasswordGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;


import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerModel {


    @NotBlank
    @Size(min = 2, max = 20)
    private String name;
    @NotBlank
    @Size(min = 2, max = 20)
    private String surname;
    @NotNull
    @Min(value = 16, message = "Min age is 16")
    @Max(value = 100, message = "Max age is 100")
    private int age;

    @NotBlank(message = "Male/Female")
    private String gender;
    @NumberFormat(pattern = "#########")
    private Long phoneNumber;
    @Email
    private String email;

    @NotBlank
    private String street;
    @NotNull
    private int streetNumber;
    @NotBlank
    private String city;
    @NotBlank
    private String country;


}
