package com.turkcell.crm.customerService.api.controllers;

import com.turkcell.crm.customerService.business.abstracts.IndividualCustomerService;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.CreateIndividualCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.UpdateIndividualCustomerRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/customerservice/api/v1/individualCustomers")
public class IndividualCustomersController {
    private final IndividualCustomerService individualCustomerService;

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public void getAll() {
        individualCustomerService.getAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void getById(@PathVariable int id) {
        individualCustomerService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        individualCustomerService.save(createIndividualCustomerRequest);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
        individualCustomerService.update(updateIndividualCustomerRequest);
    }
}
