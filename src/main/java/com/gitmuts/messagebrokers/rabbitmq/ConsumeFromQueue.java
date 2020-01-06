package com.gitmuts.messagebrokers.rabbitmq;

import com.gitmuts.messagebrokers.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumeFromQueue {

    @RabbitListener(queues = "customers")
    public void consumeCustomers (Customer customer){
        try{
            log.info("Consumed {}", customer);
        }catch (Exception e){
            log.error("Exception ", e);
        }
    }
}
