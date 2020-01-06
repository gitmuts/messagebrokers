package com.gitmuts.messagebrokers.activemq;

import com.gitmuts.messagebrokers.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumeFromQueue {


//    @JmsListener( destination = "DLQ")
//    public void receiveFromQueue(Customer customer) {
//
//        log.info("Message {}", customer);
//    }
}
