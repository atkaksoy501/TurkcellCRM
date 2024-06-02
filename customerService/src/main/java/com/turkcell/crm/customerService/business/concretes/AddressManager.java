package com.turkcell.crm.customerService.business.concretes;

import com.turkcell.crm.customerService.business.abstracts.AddressService;
import com.turkcell.crm.customerService.business.dtos.requests.Address.CreateAddressRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Address.UpdateAddressRequest;
import com.turkcell.crm.customerService.business.dtos.responses.Address.CreatedAddressResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Address.GetAddressResponseById;
import com.turkcell.crm.customerService.business.dtos.responses.Address.GetAllAddressResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Address.UpdatedAddressResponse;
import com.turkcell.crm.customerService.business.rules.AddressBusinessRules;
import com.turkcell.crm.customerService.core.utilities.mapping.ModelMapperService;
import com.turkcell.crm.customerService.dataAccess.abstracts.AddressRepository;
import com.turkcell.crm.customerService.entities.concretes.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class AddressManager implements AddressService {
    private ModelMapperService modelMapperService;
    private AddressRepository addressRepository;
    private AddressBusinessRules addressBusinessRules;

    @Override
    public CreatedAddressResponse add(CreateAddressRequest createAddressRequest) {
        addressBusinessRules.validateCreateAddressRequest(createAddressRequest);
        Address address = this.modelMapperService.forRequest().map(createAddressRequest, Address.class);
        address.setCreatedDate(LocalDateTime.now());
        Address savedAddress = addressRepository.save(address);
        return this.modelMapperService.forResponse().map(savedAddress, CreatedAddressResponse.class);
    }

    @Override
    public UpdatedAddressResponse update(UpdateAddressRequest updateAddressRequest) {
        addressBusinessRules.validateUpdateAddressRequest(updateAddressRequest);
        addressBusinessRules.checkIfAddressExists(updateAddressRequest.getId());
        Address address = addressRepository.findById(updateAddressRequest.getId()).orElse(null);
        modelMapperService.forUpdate().map(updateAddressRequest, address);
        address.setUpdatedDate(LocalDateTime.now());
        Address updatedAddress = addressRepository.save(address);
        return this.modelMapperService.forResponse().map(updatedAddress, UpdatedAddressResponse.class);
    }

    @Override
    public void delete(int id) {
      //  addressBusinessRules.checkIfCustomerHasMultipleAddresses(customerId);
      //  addressBusinessRules.checkIfAddressIsDefault(customerId,id);
        Address address = addressRepository.findById(id).orElse(null);
        address.setActive(false);
        address.setDeletedDate(LocalDateTime.now());
        addressRepository.save(address);
    }

    @Override
    public GetAddressResponseById getAddressById(int id) {
        Address address = addressRepository.findById(id).orElse(null);
        return this.modelMapperService.forResponse().map(address, GetAddressResponseById.class);
    }

    @Override
    public List<GetAllAddressResponse> getAll() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream().map(
                address -> this.modelMapperService.forResponse().map(address, GetAllAddressResponse.class)
        ).toList();
    }
}
