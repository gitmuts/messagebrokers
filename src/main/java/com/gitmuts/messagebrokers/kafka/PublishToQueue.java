package com.gitmuts.messagebrokers.kafka;

import com.gitmuts.messagebrokers.model.Customer;
import com.gitmuts.messagebrokers.service.GenDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PublishToQueue {


    @Autowired
    GenDataService genDataService;

    @Autowired
    KafkaTemplate<String, Customer> kafkaTemplate;

    public void publish() {
        try{
            List<Customer> customers = genDataService.getCustomers(10);


            for(Customer customer: customers) {
                kafkaTemplate.send("test", customer);
            }

        }catch(Exception e){
            log.error("Error occurred ", e);
        }
    }

    @Bean
    public void test() {
        publish();
    }
}
