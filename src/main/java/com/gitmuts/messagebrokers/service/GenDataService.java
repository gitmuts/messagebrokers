package com.gitmuts.messagebrokers.service;

import com.github.javafaker.Faker;
import com.gitmuts.messagebrokers.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GenDataService
{

    Faker faker = new Faker();

    public List<Customer> getCustomers(int no) {
        List<Customer> customers = new ArrayList<>();

        try {

            for(int i=0; i<no; i++){
                Customer customer = new Customer();
                customer.setName(faker.name().name());
                customer.setDob(faker.date().birthday());
                customer.setBalance(BigDecimal.valueOf(faker.number().randomDouble(2, 50, 1000000)));
                customer.setJob(faker.job().field());
                customer.setAddress(faker.address().fullAddress());
                customer.setPhoneNumber(faker.phoneNumber().phoneNumber());
                customer.setIdNumber(faker.number().numberBetween(10000000, 50000000));
                customers.add(customer);
            }

        }catch (Exception e){
            log.error("Error occurred while generating rand data");
        }
        return  customers;
    }
}
