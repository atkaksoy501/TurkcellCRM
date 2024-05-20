package com.turkcell.crm.searchService.business.concretes;

import com.turkcell.crm.searchService.business.abstracts.CustomerService;
import com.turkcell.crm.searchService.dataAccess.abstracts.CustomerRepository;
import com.turkcell.crm.searchService.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private MongoTemplate mongoTemplate;
    @Override
    public void add(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void searchByNationalityId(String nationalityId) {
        customerRepository.findByNationalityId(nationalityId);
    }

    public List<Customer> searchCustomers(
            Optional<String> nationalityId,
            Optional<Long> customerId,
            Optional<Long> accountNumber,
            Optional<Long> gsmNumber,
            Optional<String> firstName,
            Optional<String> lastName,
            Optional<Long> orderNumber) {

        Query query = new Query();

        nationalityId.ifPresent(id -> query.addCriteria(Criteria.where("nationalityId").is(id)));
        customerId.ifPresent(id -> query.addCriteria(Criteria.where("customerId").is(id)));
        accountNumber.ifPresent(id -> query.addCriteria(Criteria.where("accountNumber").is(id)));
        gsmNumber.ifPresent(id -> query.addCriteria(Criteria.where("gsmNumber").is(id)));
        firstName.ifPresent(name -> query.addCriteria(Criteria.where("firstName").regex("^" + name, "i")));
        lastName.ifPresent(name -> query.addCriteria(Criteria.where("lastName").regex("^" + name, "i")));
        orderNumber.ifPresent(number -> query.addCriteria(Criteria.where("orderNumber").is(number)));

        return mongoTemplate.find(query, Customer.class);
    }


}
