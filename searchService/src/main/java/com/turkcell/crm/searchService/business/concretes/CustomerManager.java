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
    private MongoTemplate mongoTemplate;

    @Override
    public void add(Customer customer) {customerRepository.save(customer);}

    @Override
    public void searchByNationalityId(String nationalityId) {customerRepository.findByNationalityId(nationalityId);}

    @Override
    public Page<Customer> searchCustomers(
            Optional<String> nationalityId,
            Optional<String> customerId,
            Optional<Long> accountNumber,
            Optional<Long> gsmNumber,
            Optional<String> firstName,
            Optional<String> middleName,
            Optional<String> lastName,
            Optional<Long> orderNumber,
            Pageable pageable) {

        Query query = new Query();

        nationalityId.ifPresent(id -> {
            customerBusinessRules.validateNationalityId(id);
            query.addCriteria(Criteria.where("nationalityId").is(Long.parseLong(id)));
        });
        customerId.ifPresent(id -> {
            customerBusinessRules.validateCustomerId(id);
            query.addCriteria(Criteria.where("customerId").is(Long.parseLong(id)));
        });
        accountNumber.ifPresent(id -> {
            customerBusinessRules.validateAccountNumber(id);
            query.addCriteria(Criteria.where("accountNumber").is(id));
        });
        gsmNumber.ifPresent(id -> {
            customerBusinessRules.validateGsmNumber(id);
            query.addCriteria(Criteria.where("gsmNumber").is(id));
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
