package com.gitmuts.messagebrokers.rabbitmq;


import com.gitmuts.messagebrokers.model.Customer;
import com.gitmuts.messagebrokers.service.GenDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RabbitPublishToQueue {

    @Autowired
    GenDataService genDataService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void pushCustomersToQueue() {
        try{
            List<Customer> customers = genDataService.getCustomers(100);

            for(Customer customer: customers){
                log.info("Publishing {}", customer);
                rabbitTemplate.convertAndSend("customers", customer);
            }
        }catch (Exception e){
            log.error("Exception ", e);
        }
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public void testPush() {
        pushCustomersToQueue();
    }
}
