package com.example.ATM;

import com.example.ATM.repositories.AccountEntity;
import com.example.ATM.repositories.AddressEntity;
import com.example.ATM.repositories.CustomerEntity;
import com.example.ATM.repositories.PinNumberEntity;
import com.example.ATM.resources.AccountResource;
import com.example.ATM.resources.AddressResource;
import com.example.ATM.model.CustomerModel;
import com.example.ATM.resources.CustomerResource;
import com.example.ATM.resources.PinNumberResource;
import com.example.ATM.service.LuhnAlgorithm;
import com.example.ATM.service.PasswordGenerator;

public class CustomerMapper {

    public static CustomerEntity getEntity(CustomerModel model) {

        Long tempAccountNumber = LuhnAlgorithm.generateCardNumberLuhn();
        int tempPassword = PasswordGenerator.OTP();


        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(model.getName());
        customerEntity.setSurname(model.getSurname());
        customerEntity.setAge(model.getAge());
        customerEntity.setGender(model.getGender());
        customerEntity.setPhoneNumber(model.getPhoneNumber());
        customerEntity.setEmail(model.getEmail());

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setCardNumber(tempAccountNumber);
        accountEntity.setBalance(0);
        accountEntity.setPinNumber(tempPassword);
        customerEntity.setAccount(accountEntity);

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setStreet(model.getStreet());
        addressEntity.setStreetNumber(model.getStreetNumber());
        addressEntity.setCity(model.getCity());
        addressEntity.setCountry(model.getCountry());
        customerEntity.setAddress(addressEntity);

        PinNumberEntity pinNumberEntity = new PinNumberEntity();
        pinNumberEntity.setPin(tempPassword);
        customerEntity.setPinNumber(pinNumberEntity);

        return customerEntity;
    }


    public static CustomerResource getConfirmation(CustomerEntity customerEntity) {
        CustomerResource result = new CustomerResource();
        result.setName(customerEntity.getName());
        result.setSurName(customerEntity.getSurname());
        result.setAge(customerEntity.getAge());
        result.setGender(customerEntity.getGender());
        result.setEmail(customerEntity.getEmail());
        result.setPhoneNumber(customerEntity.getPhoneNumber());
        result.setId(customerEntity.getId());

        AccountResource accountResource = new AccountResource();
        accountResource.setCardNumber(customerEntity.getAccount().getCardNumber());
        accountResource.setBalance(customerEntity.getAccount().getBalance());
        result.setAccount(accountResource);

        AddressResource addressResource = new AddressResource();
        addressResource.setId(customerEntity.getAddress().getId());
        addressResource.setStreet(customerEntity.getAddress().getStreet());
        addressResource.setNumberStreet(customerEntity.getAddress().getStreetNumber());
        addressResource.setCity(customerEntity.getAddress().getCity());
        addressResource.setCountry(customerEntity.getAddress().getCountry());
        result.setAddress(addressResource);

        PinNumberResource pinNumberResource = new PinNumberResource();
        pinNumberResource.setId(customerEntity.getPinNumber().getId());
        pinNumberResource.setPin(customerEntity.getPinNumber().getPin());
        result.setPinNumber(pinNumberResource);

        return result;
    }


    public static CustomerResource getResource(CustomerEntity customerEntity) {
        CustomerResource result = new CustomerResource();
        result.setName(customerEntity.getName());
        result.setSurName(customerEntity.getSurname());
        result.setAge(customerEntity.getAge());
        result.setGender(customerEntity.getGender());
        result.setEmail(customerEntity.getEmail());
        result.setPhoneNumber(customerEntity.getPhoneNumber());
        result.setId(customerEntity.getId());

        AddressResource addressResource = new AddressResource();
        addressResource.setId(customerEntity.getAddress().getId());
        addressResource.setStreet(customerEntity.getAddress().getStreet());
        addressResource.setNumberStreet(customerEntity.getAddress().getStreetNumber());
        addressResource.setCity(customerEntity.getAddress().getCity());
        addressResource.setCountry(customerEntity.getAddress().getCountry());
        result.setAddress(addressResource);

        PinNumberResource pinNumberResource = new PinNumberResource();
        pinNumberResource.setId(customerEntity.getPinNumber().getId());
        pinNumberResource.setPin(customerEntity.getPinNumber().getPin());
        result.setPinNumber(pinNumberResource);

        result.setAddress(addressResource);

        return result;

    }


}
