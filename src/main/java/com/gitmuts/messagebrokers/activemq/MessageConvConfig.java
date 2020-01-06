package com.gitmuts.messagebrokers.activemq;

import com.gitmuts.messagebrokers.model.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MessageConvConfig {

    @Bean
    public MappingJackson2MessageConverter messageConverter() {
        MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();

        messageConverter.setTypeIdPropertyName("_typeId");
        Map<String, Class<?>> typeIdMappings = new HashMap<String, Class<?>>();

        typeIdMappings.put("customer", Customer.class);
        messageConverter.setTypeIdMappings(typeIdMappings);

        return messageConverter;
    }
}
