package com.gitmuts.messagebrokers.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateCustomerService {

    @ServiceActivator(inputChannel = "createCustomerChannel")
    public MessageHandler createCustomer() {
        log.info("called");
        return message -> {
            System.out.println(message.getPayload());
            create(message.getPayload());
        };
    }

    private void create(Object payload) {
        log.info("Received create {}", payload);
    }
}
