package com.turkcell.crm.customerService.business.concretes;

import com.turkcell.crm.customerService.business.abstracts.ContactService;
import com.turkcell.crm.customerService.business.dtos.requests.Contact.CreateContactRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Contact.UpdateContactRequest;
import com.turkcell.crm.customerService.business.dtos.responses.Contact.CreatedContactResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Contact.GetAllContactResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Contact.GetContactResponseById;
import com.turkcell.crm.customerService.business.dtos.responses.Contact.UpdatedContactResponse;
import com.turkcell.crm.customerService.core.utilities.mapping.ModelMapperService;
import com.turkcell.crm.customerService.dataAccess.abstracts.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class ContactManager implements ContactService {
    private ModelMapperService modelMapperService;
    private ContactRepository contactRepository;
    @Override
    public CreatedContactResponse add(CreateContactRequest createContactRequest) {
        Contact contact = this.modelMapperService.forRequest().map(createContactRequest, Contact.class);
        contact.setCreatedDate(LocalDateTime.now());
        Contact savedContact = contactRepository.save(contact);
        return this.modelMapperService.forResponse().map(savedContact, CreatedContactResponse.class);
    }

    @Override
    public UpdatedContactResponse update(UpdateContactRequest updateContactRequest) {
        Contact contact = contactRepository.findById(updateContactRequest.getId()).orElse(null);
        modelMapperService.forUpdate().map(updateContactRequest, contact);
        contact.setUpdatedDate(LocalDateTime.now());
        Contact savedContact = contactRepository.save(contact);
        return this.modelMapperService.forResponse().map(savedContact, UpdatedContactResponse.class);
    }

    @Override
    public void delete(int id) {
        Contact contact = contactRepository.findById(id).orElse(null);
        contact.setActive(false);
        contact.setDeletedDate(LocalDateTime.now());
        contactRepository.save(contact);
    }

    @Override
    public GetContactResponseById getContactById(int id) {
        Contact contact = contactRepository.findById(id).orElse(null);
        return this.modelMapperService.forResponse().map(contact, GetContactResponseById.class);
    }

    @Override
    public List<GetAllContactResponse> getAll() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream().map(
                contact -> this.modelMapperService.forResponse().map(contact, GetAllContactResponse.class)
        ).toList();
    }
}
