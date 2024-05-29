package com.turkcell.crm.customerService.business.concretes;

import com.turkcell.crm.customerService.business.dtos.requests.Customer.CreateIndividualCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.UpdateIndividualCustomerRequest;
import com.turkcell.crm.customerService.business.rules.IndividualCustomerBusinessRules;
import com.turkcell.crm.customerService.core.business.abstracts.MessageService;
import com.turkcell.crm.customerService.core.business.concretes.MessageManager;
import com.turkcell.crm.customerService.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.turkcell.crm.customerService.core.mernisVerification.abstracts.MernisService;
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

    private IndividualCustomerRepository individualCustomerRepository;
    private IndividualCustomerManager individualCustomerManager;
    private MernisService mernisService;

    @BeforeEach
    void setUp(){
        individualCustomerRepository = Mockito.mock(IndividualCustomerRepository.class);
        mernisService = Mockito.mock(MernisService.class);
        ModelMapper mapper = new ModelMapper();
        ModelMapperService modelMapperService = new ModelMapperManager(mapper);
        MessageService messageService = Mockito.mock(MessageManager.class);
        IndividualCustomerBusinessRules individualCustomerBusinessRules =
                new IndividualCustomerBusinessRules(individualCustomerRepository, messageService, mernisService);
        IndividualCustomerProducer individualCustomerProducer = Mockito.mock(IndividualCustomerProducer.class);
        IndividualCustomerIdentityProducer individualCustomerIdentityProducer = Mockito.mock(IndividualCustomerIdentityProducer.class);
        individualCustomerManager = new IndividualCustomerManager(modelMapperService,individualCustomerRepository,individualCustomerBusinessRules,individualCustomerProducer,individualCustomerIdentityProducer, mernisService);
    }

    @Test
    void addIndividualCustomerWithExistingCustomer_ShouldThrowException(){

        Mockito.when(individualCustomerRepository.existsByNationalityNumber("111")).thenReturn(true);
        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setNationalityNumber("111");
        Mockito.when(individualCustomerRepository.save(individualCustomer)).thenReturn(individualCustomer);

        CreateIndividualCustomerRequest createIndividualCustomerRequest = new CreateIndividualCustomerRequest();
        createIndividualCustomerRequest.setNationalityNumber("111");

        assertThrows(BusinessException.class,() -> {
            individualCustomerManager.save(createIndividualCustomerRequest);
        });
    }

    @Test
    void updateIndividualCustomerWithNonExistingCustomer_ShouldThrowException(){

        Mockito.when(individualCustomerRepository.existsById(1)).thenReturn(false);
        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setId(1);
        Mockito.when(individualCustomerRepository.save(individualCustomer)).thenReturn(individualCustomer);

        UpdateIndividualCustomerRequest createIndividualCustomerRequest = new UpdateIndividualCustomerRequest();
        createIndividualCustomerRequest.setId(1);

        assertThrows(BusinessException.class,() -> {
            individualCustomerManager.update(createIndividualCustomerRequest);
        });
    }

    @Test
    void addIndividualCustomerSuccess(){

        Mockito.when(individualCustomerRepository.existsByNationalityNumber("111")).thenReturn(false);
        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setNationalityNumber("111");
        Mockito.when(individualCustomerRepository.save(individualCustomer)).thenReturn(individualCustomer);

        CreateIndividualCustomerRequest createIndividualCustomerRequest = new CreateIndividualCustomerRequest();
        createIndividualCustomerRequest.setNationalityNumber("111");

        individualCustomerManager.save(createIndividualCustomerRequest);
        assert true;
    }

}