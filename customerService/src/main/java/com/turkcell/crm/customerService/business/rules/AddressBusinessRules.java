package com.turkcell.crm.customerService.business.rules;

import com.turkcell.crm.core.core.exceptions.types.BusinessException;
import com.turkcell.crm.customerService.business.dtos.requests.Address.CreateAddressRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Address.UpdateAddressRequest;
import com.turkcell.crm.customerService.business.messages.Messages;
import com.turkcell.crm.customerService.core.business.abstracts.MessageService;
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
    // ekleme için boş olup olmadığı

    public void validateUpdateAddressRequest(UpdateAddressRequest updateAddressRequest) {
        validateCity(updateAddressRequest.getCity());
        validateNonEmptyField(updateAddressRequest.getDistrict(), "District");
        validateNonEmptyField(updateAddressRequest.getStreet(), "Street");
        validateNonEmptyField(updateAddressRequest.getDoorNumber(), "House Number");
        validateNonEmptyField(updateAddressRequest.getAddressDetail(), "Address Description");
    }
    //güncelleme için de aynı


    private void validateCity(String city) {
        try {
            City.valueOf(city.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BusinessException(messageService.getMessage(Messages.AddressErrors.INVALID_CITY+city));
        }
    }
    //enum tablasondan bulur büyük harfe çevirir doğru mu değil mi bakar


    private void validateNonEmptyField(String field, String fieldName) {
        if (field == null || field.trim().isEmpty()) {
            throw new BusinessException(messageService.getMessage(Messages.AddressErrors.CANNOT_BE_EMPTY));
        }
    }
    // her hangi bir alan boş mu değil mi onu sorgular

    public void checkIfAddressExists(int id) {
        if (!addressRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.AddressErrors.ADDRESS_NOT_FOUND));
        }
    }
    //belirtilen adres var mı yokmu onu bulur id ye göre

    public void checkIfCustomerHasMultipleAddresses(int customerId) {
        long addressCount = addressRepository.countByCustomerId(customerId);
        if (addressCount < 1) {
            throw new BusinessException(messageService.getMessage(Messages.AddressErrors.CUSTOMER_SHOULD_HAVE_AT_LEAST_ONE_ADDRESS));
        }
    }
    //en az bir adresi olduğunu kontrol eder


    public void checkIfAddressIsDefaultAddress(int customerId, int addressId) {
        Address defaultAddress = addressRepository.findByCustomerIdAndDefaultAddress(customerId, true);
        if (defaultAddress != null && defaultAddress.getId().equals(addressId)) {
            throw new BusinessException(messageService.getMessage(Messages.AddressErrors.CANNOT_DELETE_DEFAULT_ADDRESS));
        }
    }

    //varsayılan adres burası mı onu konrtol etmek için



}
