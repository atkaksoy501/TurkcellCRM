package com.turkcell.crm.customerService.controllers;

import com.turkcell.crm.customerService.business.abstracts.CustomerService;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.CreateCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.UpdateCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.CreatedCustomerResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.GetAllCustomerResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.GetCustomerResponseById;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.UpdatedCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomersController {

    private CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCustomerResponse add(@Valid @RequestBody CreateCustomerRequest customer) {
        return customerService.add(customer);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCustomerResponse> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetCustomerResponseById getById(@PathVariable int id) {
        return customerService.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdatedCustomerResponse update(@Valid @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return customerService.update(updateCustomerRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        customerService.delete(id);
    }
}
