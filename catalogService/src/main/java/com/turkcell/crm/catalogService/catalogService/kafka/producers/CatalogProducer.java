package com.turkcell.crm.catalogService.catalogService.kafka.producers;

import com.turkcell.crm.common.events.catalog.CreateCatalogEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class CatalogProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogProducer.class);
    private final KafkaTemplate<String,Object> kafkaTemplate;
    public CatalogProducer(KafkaTemplate<String,Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(CreateCatalogEvent createCatalogEvent){
        LOGGER.info(String.format("Catalog added =>%s",createCatalogEvent.toString()));
        Message<CreateCatalogEvent> message = MessageBuilder.withPayload(createCatalogEvent)
                .setHeader(KafkaHeaders.TOPIC,"catalog-created")
                .build();
        kafkaTemplate.send(message);
    }
}
