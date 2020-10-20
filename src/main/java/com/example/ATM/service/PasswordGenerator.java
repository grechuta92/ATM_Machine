package com.example.ATM.service;

import java.util.Random;

public class PasswordGenerator {
    public static int OTP()
    {
        String numbers = "0123456789";

        Random rndm_method = new Random();

        char[] otp = new char[4];

        for (int i = 0; i < 4; i++)
        {
            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
        return Integer.parseInt(String.valueOf(otp));
    }
}
