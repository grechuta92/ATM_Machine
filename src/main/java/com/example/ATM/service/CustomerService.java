package com.example.ATM.service;

import com.example.ATM.CustomerMapper;
import com.example.ATM.repositories.CustomerEntity;
import com.example.ATM.repositories.CustomerRepository;
import com.example.ATM.resources.CustomerResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    private boolean loginStatus = false;
    private String tempCardNumber = "";

    public CustomerResource create(CustomerEntity customer) {
        CustomerEntity entity = customerRepository.save(customer);
        return CustomerMapper.getConfirmation(entity);
    }

    public String login(Long cardNumber, int pinNumber) {
        CustomerEntity customer = customerRepository.findByAccountCardNumber(cardNumber);
        if (loginStatus == false && pinNumber == customer.getPinNumber().getPin()) {
            tempCardNumber = String.valueOf(cardNumber);
            loginStatus = true;
            return "Logged in!";
        } else if (loginStatus == true) {
            return "You are already Logged In";
        } else {
            return "Wrong PIN Number!";
        }
    }

    public String depositMoney(Long cardNumber, int pinNumber, double value) {
        if(tempCardNumber.equals(String.valueOf(cardNumber))) {
            CustomerEntity customerAccount = customerRepository.findByAccountCardNumber(cardNumber);
            double tempValueOfMoney = customerAccount.getAccount().getBalance();

            if (loginStatus) {
                if (pinNumber == customerAccount.getPinNumber().getPin()) {
                    customerAccount.getAccount().setBalance(tempValueOfMoney + value);
                    customerRepository.save(customerAccount);
                    return "The Amount of " + value
                            + " has been successfully deposited into the account with number: \n"
                            + customerAccount.getAccount().getCardNumber();
                } else {
                    return "Wrong PIN number!";
                }
            } else {
                return "You are not logged in!\n"
                        + "Please Log In!";
            }
        } else {
            return "You are already logged in on another Account!";
        }
    }

    public String withdrawalMoney(final Long cardNumber, final int pinNumber, final double value) {
        if(tempCardNumber.equals(String.valueOf(cardNumber))) {
            CustomerEntity customerAccount = customerRepository.findByAccountCardNumber(cardNumber);
            double tempValueOfMoney = customerAccount.getAccount().getBalance();

            if (loginStatus) {
                if (pinNumber == customerAccount.getPinNumber().getPin()) {
                    if (value < tempValueOfMoney) {
                        customerAccount.getAccount().setBalance(tempValueOfMoney - value);
                        customerRepository.save(customerAccount);
                        return "PLN " + value + " has been successfully withdrawal from the account with number: \n"
                                + customerAccount.getAccount().getCardNumber();
                    } else {
                        return "No funds on the Account!";
                    }
                } else {
                    return "Wrong PIN number!";
                }
            } else {
                return "You are not logged in!";
            }
        }else {
            return "You are already logged in on another Account!";
        }
    }


    public String checkAccountBalance(final Long cardNumber, final int pinNumber) {
        if(tempCardNumber.equals(String.valueOf(cardNumber))) {
            CustomerEntity customerAccount = customerRepository.findByAccountCardNumber(cardNumber);
            if (customerAccount.getPinNumber().getPin() == pinNumber) {
                return "Account Balance of number:\n"
                        + customerAccount.getAccount().getCardNumber()
                        + "\n is:\n"
                        + customerAccount.getAccount().getBalance();
            } else {
                return "Wrong PIN Number!";
            }
        }else {
            return "You are already logged in on another Account!";
        }
    }


    public String logout() {
        loginStatus = false;
        tempCardNumber = "";
        return "Thank You for using our services! \n See you soon!";
    }
}