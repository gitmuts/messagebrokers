package com.gitmuts.messagebrokers.service;

import com.gitmuts.messagebrokers.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class CreateCustomerTransformer {

    @Bean
    @Transformer(inputChannel = "transformCustomer", outputChannel = "createCustomerChannel")
    public GenericTransformer<Customer, Customer> customerSegment() {
        return s -> {
            if (s.getBalance().compareTo(new BigDecimal(100000)) == 1) {
                s.setSegment("GOLD");
            } else if (s.getBalance().compareTo(new BigDecimal(50000)) == 1)
                s.setSegment("SILVER");
            else
                s.setSegment("BRONZE");

            log.info("Customer assigned {}", s.getSegment());
            return s;
        };
    }
}
