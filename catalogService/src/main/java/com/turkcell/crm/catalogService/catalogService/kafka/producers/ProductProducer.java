package com.turkcell.crm.catalogService.catalogService.kafka.producers;

import com.turkcell.crm.catalogService.catalogService.entities.concretes.Product;
import com.turkcell.crm.common.events.catalog.CreateCatalogEvent;
import com.turkcell.crm.common.events.catalog.CreateProductEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class ProductProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductProducer.class);
    private final KafkaTemplate<String,Object> kafkaTemplate;
    public ProductProducer(KafkaTemplate<String,Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(CreateProductEvent createProductEvent){
        LOGGER.info(String.format("Catalog added =>{}",createProductEvent.toString()));
        Message<CreateProductEvent> message = MessageBuilder.withPayload(createProductEvent)
                .setHeader(KafkaHeaders.TOPIC,"product-created")
                .build();
        kafkaTemplate.send(message);
    }

}
