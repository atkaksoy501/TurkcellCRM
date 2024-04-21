package com.turkcell.crm.customerService.business.abstracts;

import com.turkcell.crm.customerService.business.dtos.requests.Contact.CreateContactRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Contact.UpdateContactRequest;
import com.turkcell.crm.customerService.business.dtos.responses.Contact.CreatedContactResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Contact.GetAllContactResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Contact.GetContactResponseById;
import com.turkcell.crm.customerService.business.dtos.responses.Contact.UpdatedContactResponse;
import com.turkcell.crm.customerService.entities.concretes.Contact;

import java.util.List;

public interface ContactService {
    CreatedContactResponse add(CreateContactRequest createContactRequest);
    UpdatedContactResponse update(UpdateContactRequest updateContactRequest);
    void delete(int id);
    GetContactResponseById getContactById(int id);
    List<GetAllContactResponse> getAll();
}
