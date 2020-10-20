package com.example.ATM.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LuhnAlgorithm {

    private static final Random random = new Random();
    private static final int[] generateNumber = new int[16];
    private static int[] tempNumber = new int[16];
    private static String luhnCardNumber;
    private static final ArrayList<String> listOfAccountNumbers = new ArrayList();

    public static Long generateCardNumberLuhn() {
        int sum = 0;
        generateNumber[0] = 4;
        for (int i = 1; i < 6; i++) {
            generateNumber[i] = 0;
        }
        for (int i = 6; i < generateNumber.length - 1; i++) {
            generateNumber[i] = random.nextInt(10);
        }
        tempNumber = generateNumber.clone();

        for (int i = 0; i < tempNumber.length - 1; i = i + 2) {
            tempNumber[i] *= 2;
        }
        for (int i = 0; i < tempNumber.length - 1; i++) {
            if (tempNumber[i] > 9) {
                tempNumber[i] -= 9;
            }
        }

        for (int i = 0; i < tempNumber.length - 1; i++) {
            sum += tempNumber[i];
        }
        if (sum % 10 != 0) {
            generateNumber[15] = (10 - (sum % 10));
        } else {
            generateNumber[15] = 0;
        }

        luhnCardNumber = Arrays.toString(generateNumber).replace(", ", "").replace("[", "").replace("]", "");

        checkDoesCardNumberExist();

        return Long.valueOf(luhnCardNumber);
    }

    private void checkSumOfLuhnRequirement(int[] tab) {
        int checkSum = 0;
        for (int i = 0; i < tab.length - 1; i++) {
            checkSum += tab[i];
        }

        System.out.println(checkSum);
    }

    private static void checkDoesCardNumberExist() {
        if (!listOfAccountNumbers.contains(luhnCardNumber)) {
            listOfAccountNumbers.add(luhnCardNumber);
        } else {
            generateCardNumberLuhn();
        }
    }


}