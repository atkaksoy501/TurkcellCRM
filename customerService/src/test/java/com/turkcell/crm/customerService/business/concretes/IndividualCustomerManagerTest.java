package com.turkcell.crm.customerService.business.concretes;

import com.turkcell.crm.customerService.business.dtos.requests.Customer.CreateIndividualCustomerRequest;
import com.turkcell.crm.customerService.business.rules.IndividualCustomerBusinessRules;
import com.turkcell.crm.customerService.core.business.abstracts.MessageService;
import com.turkcell.crm.customerService.core.business.concretes.MessageManager;
import com.turkcell.crm.customerService.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.turkcell.crm.customerService.core.utilities.mapping.ModelMapperManager;
import com.turkcell.crm.customerService.core.utilities.mapping.ModelMapperService;
import com.turkcell.crm.customerService.dataAccess.abstracts.IndividualCustomerRepository;
import com.turkcell.crm.customerService.entities.concretes.IndividualCustomer;
import com.turkcell.crm.customerService.kafka.producers.IndividualCustomerIdentityProducer;
import com.turkcell.crm.customerService.kafka.producers.IndividualCustomerProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import static org.junit.jupiter.api.Assertions.assertThrows;


class IndividualCustomerManagerTest {

    IndividualCustomerRepository individualCustomerRepository;

    @BeforeEach
    void setUp(){
    }

    @Test
    void addIndividualCustomerWithExistingCustomer_ShouldThrowException(){

        individualCustomerRepository = Mockito.mock(IndividualCustomerRepository.class);
        Mockito.when(individualCustomerRepository.existsByNationalityNumber("111")).thenReturn(true);
        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setNationalityNumber("111");
        Mockito.when(individualCustomerRepository.save(individualCustomer)).thenReturn(individualCustomer);

        ModelMapper mapper = new ModelMapper();
        ModelMapperService modelMapperService = new ModelMapperManager(mapper);

        MessageService messageService = Mockito.mock(MessageManager.class);


        IndividualCustomerBusinessRules individualCustomerBusinessRules = new IndividualCustomerBusinessRules(individualCustomerRepository,messageService);

        IndividualCustomerProducer individualCustomerProducer = Mockito.mock(IndividualCustomerProducer.class);
        IndividualCustomerIdentityProducer individualCustomerIdentityProducer = Mockito.mock(IndividualCustomerIdentityProducer.class);

        IndividualCustomerManager individualCustomerManager = new IndividualCustomerManager(modelMapperService,individualCustomerRepository,individualCustomerBusinessRules,individualCustomerProducer,individualCustomerIdentityProducer);

        CreateIndividualCustomerRequest createIndividualCustomerRequest = new CreateIndividualCustomerRequest();
        createIndividualCustomerRequest.setNationalityNumber("111");

        assertThrows(BusinessException.class,() ->{

            individualCustomerManager.save(createIndividualCustomerRequest);
        });
    }

}