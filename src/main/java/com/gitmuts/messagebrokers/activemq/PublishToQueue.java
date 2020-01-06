package com.gitmuts.messagebrokers.activemq;

import com.gitmuts.messagebrokers.model.Customer;
import com.gitmuts.messagebrokers.service.GenDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PublishToQueue {

//    @Autowired
//    JmsTemplate jmsTemplate;
//
//    @Autowired
//    GenDataService genDataService;
//
//    public void pushCustomerInfo() {
//        try{
//            List<Customer> customers = genDataService.getCustomers(20);
//
//            for(Customer customer: customers) {
//                log.debug("Pushing {}", customer);
//                jmsTemplate.convertAndSend("DLQ", customer);
//            }
//
//        }catch (Exception e){
//            log.error("Error ", e);
//        }
//    }
//
//    @Bean
//    public void test () {
//        pushCustomerInfo();
//    }

}
