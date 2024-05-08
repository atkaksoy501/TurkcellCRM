package com.turkcell.crm.searchService.api.controllers;

import com.turkcell.crm.searchService.business.abstracts.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/searchservice/api/v1/customers")
public class CustomersController {
    private final CustomerService customerService;

    @GetMapping("/search/{natinonalityId}")
    public void searchByNationalityId(@PathVariable String natinonalityId) {
        customerService.searchByNationalityId(natinonalityId);
    }
}
