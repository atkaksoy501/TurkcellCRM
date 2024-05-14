package com.turkcell.crm.customerService.kafka.producers;

import com.turkcell.crm.common.events.customer.CreateIndividualCustomerEvent;
import com.turkcell.crm.common.events.identity.CreateCustomerIdentityEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class IndividualCustomerIdentityProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndividualCustomerIdentityProducer.class);
    private final KafkaTemplate<String,Object> kafkaTemplate;
    public IndividualCustomerIdentityProducer(KafkaTemplate<String,Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(CreateCustomerIdentityEvent createCustomerIdentityEvent){
        LOGGER.info(String.format("Individual Customer identity enabled =>%s", createCustomerIdentityEvent.toString()));
        Message<CreateCustomerIdentityEvent> message = MessageBuilder.withPayload(createCustomerIdentityEvent)
                .setHeader(KafkaHeaders.TOPIC,"customer-identity-created")
                .build();
        kafkaTemplate.send(message);
    }
}
