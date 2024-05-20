package com.turkcell.crm.searchService.api.controllers;

import com.turkcell.crm.searchService.business.abstracts.CustomerService;
import com.turkcell.crm.searchService.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/searchservice/api/v1/customers")
public class CustomersController {
    private final CustomerService customerService;

    @GetMapping("/search/{natinonalityId}")
    public void searchByNationalityId(@PathVariable String natinonalityId) {
        customerService.searchByNationalityId(natinonalityId);
    }

    @GetMapping("/search")
    public List<Customer> searchCustomers(
            @RequestParam Optional<String> nationalityId,
            @RequestParam Optional<Long> customerId,
            @RequestParam Optional<Long> accountNumber,
            @RequestParam Optional<Long> gsmNumber,
            @RequestParam Optional<String> firstName,
            @RequestParam Optional<String> lastName,
            @RequestParam Optional<Long> orderNumber) {

        return customerService.searchCustomers(
                nationalityId, customerId, accountNumber, gsmNumber, firstName, lastName, orderNumber);
    }

}
