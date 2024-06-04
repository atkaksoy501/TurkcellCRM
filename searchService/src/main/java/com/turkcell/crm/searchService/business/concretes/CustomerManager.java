package com.turkcell.crm.searchService.business.concretes;

import com.turkcell.crm.searchService.business.abstracts.CustomerService;
import com.turkcell.crm.searchService.business.rules.CustomerBusinessRules;
import com.turkcell.crm.searchService.dataAccess.abstracts.CustomerRepository;
import com.turkcell.crm.searchService.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {

    private final CustomerBusinessRules customerBusinessRules;
    private final CustomerRepository customerRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public void add(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> searchCustomers(
            Optional<String> nationalityId,
            Optional<String> customerId,
            Optional<String> accountNumber,
            Optional<String> mobilePhoneNumber,
            Optional<String> firstName,
            Optional<String> middleName,
            Optional<String> lastName,
            Optional<String> orderNumber,
            Pageable pageable
    ) {

        Query query = new Query();

        nationalityId.ifPresent(id -> {
            customerBusinessRules.validateNationalityId(id);
            query.addCriteria(Criteria.where("nationalityId").is(id));
        });
        customerId.ifPresent(id -> {
            customerBusinessRules.validateCustomerId(id);
            query.addCriteria(Criteria.where("customerId").is(Long.parseLong(id)));
        });
        accountNumber.ifPresent(number -> {
            customerBusinessRules.validateAccountNumber(number);
            query.addCriteria(Criteria.where("accountNumber").is(number));
        });
        mobilePhoneNumber.ifPresent(number -> {
            customerBusinessRules.validateMobilePhoneNumber(number);
            query.addCriteria(Criteria.where("mobilePhoneNumber").is(number));
        });
        firstName.ifPresent(name -> query.addCriteria(Criteria.where("firstName").regex("^" + name, "i")));
        middleName.ifPresent(name -> query.addCriteria(Criteria.where("middleName").regex("^" + name, "i")));
        lastName.ifPresent(name -> query.addCriteria(Criteria.where("lastName").regex("^" + name, "i")));
        orderNumber.ifPresent(number -> {
            customerBusinessRules.validateOrderNumber(number);
            query.addCriteria(Criteria.where("orderNumber").is(number));
        });

        long total = mongoTemplate.count(query, Customer.class);

        List<Customer> customers = mongoTemplate.find(query.with(pageable), Customer.class);

        customerBusinessRules.checkCustomerFound(!customers.isEmpty());

        return new PageImpl<>(customers, pageable, total);
    }
}
