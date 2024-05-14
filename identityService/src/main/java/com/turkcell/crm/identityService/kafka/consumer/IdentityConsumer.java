package com.turkcell.crm.identityService.kafka.consumer;

import com.turkcell.crm.common.events.customer.CreateIndividualCustomerEvent;
import com.turkcell.crm.common.events.identity.CreateCustomerIdentityEvent;
import com.turkcell.crm.identityService.business.abstracts.UserService;
import com.turkcell.crm.identityService.core.utilities.mapping.ModelMapperService;
import com.turkcell.crm.identityService.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IdentityConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(IdentityConsumer.class);
    private UserService userService;
    private ModelMapperService modelMapperService;

    @KafkaListener(topics = "customer-identity-created", groupId="customer-identity-create")
    public void consume(CreateCustomerIdentityEvent customerIdentityEvent){
        User user = modelMapperService.forRequest().map(customerIdentityEvent, User.class);

        this.userService.register(user);
    }
}
