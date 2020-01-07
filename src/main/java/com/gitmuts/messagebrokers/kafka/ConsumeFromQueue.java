package com.gitmuts.messagebrokers.kafka;

import com.gitmuts.messagebrokers.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumeFromQueue {

    @KafkaListener(topics = "test", groupId = "test")
    public void handleMessages(Customer customer) {
        try{
            log.info("Received {}", customer);
        }catch(Exception e){
            log.error("Exception  ", e);
        }
    }
}