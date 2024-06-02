package com.turkcell.crm.customerService.business.rules;

import com.turkcell.crm.customerService.business.dtos.requests.Address.CreateAddressRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Address.UpdateAddressRequest;
import com.turkcell.crm.customerService.business.messages.Messages;
import com.turkcell.crm.customerService.core.business.abstracts.MessageService;
import com.turkcell.crm.customerService.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.turkcell.crm.customerService.dataAccess.abstracts.AddressRepository;
import com.turkcell.crm.customerService.entities.concretes.Address;
import com.turkcell.crm.customerService.entities.concretes.enums.City;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressBusinessRules {

    private final AddressRepository addressRepository;
    private final MessageService messageService;

    public void validateCreateAddressRequest(CreateAddressRequest createAddressRequest) {
        validateCity(createAddressRequest.getCity());
        validateNonEmptyField(createAddressRequest.getDistrict(), "District");
        validateNonEmptyField(createAddressRequest.getStreet(), "Street");
        validateNonEmptyField(createAddressRequest.getDoorNumber(), "House Number");
        validateNonEmptyField(createAddressRequest.getAddressDetail(), "Address Description");
    }
    public void validateUpdateAddressRequest(UpdateAddressRequest updateAddressRequest) {
        validateCity(updateAddressRequest.getCity());
        validateNonEmptyField(updateAddressRequest.getDistrict(), "District");
        validateNonEmptyField(updateAddressRequest.getStreet(), "Street");
        validateNonEmptyField(updateAddressRequest.getDoorNumber(), "House Number");
        validateNonEmptyField(updateAddressRequest.getAddressDetail(), "Address Description");
    }



    private void validateCity(String city) {
        try {
            City.valueOf(city.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BusinessException(messageService.getMessage(Messages.AddressErrors.INVALID_CITY+city));
        }
    }

    private void validateNonEmptyField(String field, String fieldName) {
        if (field == null || field.trim().isEmpty()) {
            throw new BusinessException(messageService.getMessage(Messages.AddressErrors.CANNOT_BE_EMPTY));
        }
    }

    public void checkIfAddressExists(int id) {
        if (!addressRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.AddressErrors.ADDRESS_NOT_FOUND));
        }
    }
    public void checkIfCustomerHasMultipleAddresses(int customerId) {
        long addressCount = addressRepository.countByCustomerId(customerId);
        if (addressCount <= 1) {
            throw new BusinessException(messageService.getMessage(Messages.AddressErrors.CUSTOMER_SHOULD_HAVE_AT_LEAST_ONE_ADDRESS));
        }
    }

    public void checkIfAddressIsDefault(int customerId, int addressId) {
        Address defaultAddress = addressRepository.findByCustomerIdAndIsDefault(customerId, true);
        if (defaultAddress != null && defaultAddress.getId().equals(addressId)) {
            throw new BusinessException(messageService.getMessage(Messages.AddressErrors.CANNOT_DELETE_DEFAULT_ADDRESS));
        }
    }



}
