package com.example.ATM.controller;

import com.example.ATM.CustomerMapper;
import com.example.ATM.model.TextLogModel;
import com.example.ATM.repositories.CustomerEntity;
import com.example.ATM.model.CustomerModel;
import com.example.ATM.resources.CustomerResource;
import com.example.ATM.service.CustomerService;
import com.example.ATM.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController("Person")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    private LogService logService;


    @PostMapping("/NewCustomer")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResource addCustomer(@RequestBody @Valid CustomerModel customerModel) {
        CustomerEntity customerEntity = CustomerMapper.getEntity(customerModel);

        logService.save("Creating a new Customer", LocalDateTime.now());
        return customerService.create(customerEntity);
    }

    @GetMapping("/Login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@Valid Long cardNumber, @Valid int pinNumber) {
        logService.save("Logging In", LocalDateTime.now());
        return customerService.login(cardNumber, pinNumber);
    }

    @PutMapping("/Deposit")
    @ResponseStatus(HttpStatus.OK)
    public String depositMoney(@RequestParam Long cardNumber, @RequestParam int pinNumber, @RequestParam double value) {
        logService.save("Depositing Money", LocalDateTime.now());

        return customerService.depositMoney(cardNumber, pinNumber, value);
    }

    @PutMapping("/Withdraw")
    @ResponseStatus(HttpStatus.OK)
    public String withdrawMoney(@RequestParam Long cardNumber, @RequestParam int pinNumber, @RequestParam double value) {
        logService.save("Withdrawing Money", LocalDateTime.now());
        return customerService.withdrawalMoney(cardNumber, pinNumber, value);
    }

    @GetMapping("/AccountBalance")
    @ResponseStatus(HttpStatus.OK)
    public String accountBalance(@Valid Long cardNumber,@Valid int pinNumber) {
        logService.save("Checking Banking Account Balance", LocalDateTime.now());
        return customerService.checkAccountBalance(cardNumber, pinNumber);
    }

    @GetMapping("/Logout")
    @ResponseStatus(HttpStatus.OK)
    public String logout(){{
        logService.save("Logged out",LocalDateTime.now());
        return customerService.logout();

    }
    }

    @GetMapping("/GetLogs")
    @ResponseStatus(HttpStatus.OK)
    public List<TextLogModel> getLogs() {
        return logService.getLogDb();
    }

}
