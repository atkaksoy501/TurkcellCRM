package com.turkcell.crm.customerService.api.controllers;

import com.turkcell.crm.customerService.business.abstracts.AddressService;
import com.turkcell.crm.customerService.business.dtos.requests.Address.CreateAddressRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Address.UpdateAddressRequest;
import com.turkcell.crm.customerService.business.dtos.responses.Address.CreatedAddressResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Address.GetAddressResponseById;
import com.turkcell.crm.customerService.business.dtos.responses.Address.GetAllAddressResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Address.UpdatedAddressResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customerservice/api/v1/addresses")
public class AddressesController {
    private AddressService addressService;

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllAddressResponse> getAll() {
        return addressService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        addressService.delete(id);
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetAddressResponseById getById(@PathVariable int id) {
        return addressService.getAddressById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedAddressResponse update(@RequestBody UpdateAddressRequest updateAddressRequest) {
        return addressService.update(updateAddressRequest);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedAddressResponse add(@RequestBody CreateAddressRequest createAddressRequest) {
        return addressService.add(createAddressRequest);
    }


}
