package com.turkcell.crm.searchService.api.controllers;

import com.turkcell.crm.searchService.business.abstracts.CustomerService;
import com.turkcell.crm.searchService.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomersController {
    private final CustomerService customerService;

    @GetMapping("/search")
    public Page<Customer> searchCustomers(
            @RequestParam Optional<String> nationalityId,
            @RequestParam Optional<String> customerId,
            @RequestParam Optional<String> accountNumber,
            @RequestParam Optional<String> mobilePhoneNumber,
            @RequestParam Optional<String> firstName,
            @RequestParam Optional<String> middleName,
            @RequestParam Optional<String> lastName,
            @RequestParam Optional<String> orderNumber,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        Pageable pageable = PageRequest.of(page, size);
        return customerService.searchCustomers(
                nationalityId, customerId, accountNumber, mobilePhoneNumber, firstName, middleName, lastName, orderNumber, pageable);
    }
}
