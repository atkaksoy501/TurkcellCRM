package com.turkcell.crm.searchService.kafka.consumers;

import com.turkcell.crm.common.events.catalog.CreateProductEvent;
import com.turkcell.crm.searchService.business.abstracts.ProductService;
import com.turkcell.crm.searchService.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductConsumer.class);

    private ProductService productService;

    @KafkaListener(topics = "product-created",groupId="product-create")
    public void consume(CreateProductEvent createProductEvent){
        LOGGER.info("Product event consumed => {}", createProductEvent);
        Product product=new Product();
        product.setId(createProductEvent.getId());
        product.setName(createProductEvent.getName());
        product.setDescription(createProductEvent.getDescription());
        product.setPrice(createProductEvent.getPrice());
        product.setStockAmount(createProductEvent.getStockAmount());
        this.productService.add(product);
    }
}
