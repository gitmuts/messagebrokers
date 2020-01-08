package com.gitmuts.messagebrokers.service;

import com.gitmuts.messagebrokers.model.Customer;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@Component
@MessagingGateway(defaultRequestChannel = "customerFilter")
public interface CustomerCreateGateway {
    Object createCustomer(Customer customer);
}
