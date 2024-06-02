package com.turkcell.crm.orderService.kafka.producers;

import com.turkcell.crm.common.events.order.CreateOrderProductsEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);
    private final KafkaTemplate<String,Object> kafkaTemplate;
    public OrderProducer(KafkaTemplate<String,Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(CreateOrderProductsEvent createOrderProductsEvent){
        LOGGER.info(String.format("Order Products added =>{}",createOrderProductsEvent.toString()));
        Message<CreateOrderProductsEvent> message = MessageBuilder.withPayload(createOrderProductsEvent)
                .setHeader(KafkaHeaders.TOPIC,"order-products-created")
                .build();
        kafkaTemplate.send(message);
    }
}
