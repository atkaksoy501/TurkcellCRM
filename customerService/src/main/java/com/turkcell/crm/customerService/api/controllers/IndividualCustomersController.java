package com.turkcell.crm.customerService.api.controllers;

import com.turkcell.crm.customerService.business.abstracts.IndividualCustomerService;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.CreateIndividualCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Customer.UpdateIndividualCustomerRequest;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.GetAllIndividualCustomersResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.GetIndividualCustomerResponseById;
import com.turkcell.crm.customerService.business.dtos.responses.Customer.UpdatedIndividualCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/individualCustomers")
public class IndividualCustomersController {
    private final IndividualCustomerService individualCustomerService;

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllIndividualCustomersResponse> getAll() {
        return individualCustomerService.getAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetIndividualCustomerResponseById getById(@PathVariable int id) {
        return individualCustomerService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        individualCustomerService.save(createIndividualCustomerRequest);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedIndividualCustomerResponse update(@Valid @RequestBody UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
        return individualCustomerService.update(updateIndividualCustomerRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        individualCustomerService.delete(id);
    }
}
