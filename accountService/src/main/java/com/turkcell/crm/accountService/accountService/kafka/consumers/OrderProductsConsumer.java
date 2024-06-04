package com.turkcell.crm.accountService.accountService.kafka.consumers;

import com.turkcell.crm.accountService.accountService.business.abstracts.AccountService;
import com.turkcell.crm.accountService.accountService.business.dtos.requests.Account.UpdateAccountRequest;
import com.turkcell.crm.accountService.accountService.dataAccess.abstracts.AccountRepository;
import com.turkcell.crm.accountService.accountService.entities.concretes.Account;
import com.turkcell.crm.common.events.order.CreateOrderProductsEvent;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderProductsConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProductsConsumer.class);
    private AccountService accountService;

    @KafkaListener(topics = "order-products-created",groupId="order-products-create")
    public void consume(CreateOrderProductsEvent createdOrderProductsEvent){

        UpdateAccountRequest updateAccountRequest = new UpdateAccountRequest();
        updateAccountRequest.setId(createdOrderProductsEvent.getAccountId());
        updateAccountRequest.setProductIds(createdOrderProductsEvent.getProductIds());
        accountService.update(updateAccountRequest);
    }
}
