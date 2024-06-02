package com.turkcell.crm.searchService.kafka.consumers;

import com.turkcell.crm.common.events.catalog.CreateCatalogEvent;
import com.turkcell.crm.searchService.business.abstracts.CatalogService;
import com.turkcell.crm.searchService.entities.concretes.Catalog;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CatalogConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogConsumer.class);
    private CatalogService catalogService;
    @KafkaListener(topics = "catalog-created",groupId="catalog-create")
    public void Consume(CreateCatalogEvent createCatalogEvent){

        Catalog catalog=new Catalog();
        catalog.setId(createCatalogEvent.getId());
        catalog.setName(createCatalogEvent.getName());
        this.catalogService.add(catalog);
    }
}
