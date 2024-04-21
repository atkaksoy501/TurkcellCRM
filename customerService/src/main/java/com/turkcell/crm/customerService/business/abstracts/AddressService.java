package com.turkcell.crm.customerService.business.abstracts;

import com.turkcell.crm.customerService.business.dtos.requests.Address.CreateAddressRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Address.UpdateAddressRequest;
import com.turkcell.crm.customerService.business.dtos.responses.Address.CreatedAddressResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Address.GetAddressResponseById;
import com.turkcell.crm.customerService.business.dtos.responses.Address.GetAllAddressResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Address.UpdatedAddressResponse;
import com.turkcell.crm.customerService.entities.concretes.Address;

import java.util.List;

public interface AddressService {
    CreatedAddressResponse add(CreateAddressRequest createAddressRequest);
    UpdatedAddressResponse update(UpdateAddressRequest updateAddressRequest);
    void delete(int id);
    GetAddressResponseById getAddressById(int id);
    List<GetAllAddressResponse> getAll();


}
