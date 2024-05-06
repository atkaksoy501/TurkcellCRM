package com.turkcell.crm.customerService.kafka.producers;

import com.turkcell.crm.common.events.identity.CreateCustomerRequest;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class CustomerProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerProducer.class);
    private final KafkaTemplate<String,Object> kafkaTemplate;
    public CustomerProducer(KafkaTemplate<String,Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(CreateCustomerRequest customerCreatedEvent){
        LOGGER.info(String.format("Customer added =>%s",customerCreatedEvent.toString()));
        Message<CreateCustomerRequest> message = MessageBuilder.withPayload(customerCreatedEvent)
                .setHeader(KafkaHeaders.TOPIC,"customer-created")
                .build();
        kafkaTemplate.send(message);
    }

}
