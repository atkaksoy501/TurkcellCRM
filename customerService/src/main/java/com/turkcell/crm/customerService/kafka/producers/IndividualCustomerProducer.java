package com.turkcell.crm.customerService.kafka.producers;

import com.turkcell.crm.common.events.identity.CreateIndividualCustomerEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class IndividualCustomerProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndividualCustomerProducer.class);
    private final KafkaTemplate<String,Object> kafkaTemplate;
    public IndividualCustomerProducer(KafkaTemplate<String,Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(CreateIndividualCustomerEvent createIndividualCustomerEvent){
        LOGGER.info(String.format("Individual Customer added =>%s",createIndividualCustomerEvent.toString()));
        Message<CreateIndividualCustomerEvent> message = MessageBuilder.withPayload(createIndividualCustomerEvent)
                .setHeader(KafkaHeaders.TOPIC,"individual-customer-created")
                .build();
        kafkaTemplate.send(message);
    }
}
