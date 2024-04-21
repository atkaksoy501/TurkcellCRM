package com.turkcell.crm.customerService.api.controllers;

import com.turkcell.crm.customerService.business.abstracts.ContactService;
import com.turkcell.crm.customerService.business.dtos.requests.Contact.CreateContactRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Contact.UpdateContactRequest;
import com.turkcell.crm.customerService.business.dtos.responses.Contact.CreatedContactResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Contact.GetAllContactResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Contact.GetContactResponseById;
import com.turkcell.crm.customerService.business.dtos.responses.Contact.UpdatedContactResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customerservice/api/v1/contacts")
public class ContactsController {
    private ContactService contactService;

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllContactResponse> getAll() {
        return contactService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        contactService.delete(id);
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetContactResponseById getById(@PathVariable int id) {
        return contactService.getContactById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedContactResponse update(@RequestBody UpdateContactRequest updateContactRequest) {
        return contactService.update(updateContactRequest);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedContactResponse add(@RequestBody CreateContactRequest createContactRequest) {
        return contactService.add(createContactRequest);
    }

}
