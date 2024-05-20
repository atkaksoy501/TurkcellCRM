package com.turkcell.crm.invoiceService.invoiceService.api.controllers;

import com.turkcell.crm.invoiceService.invoiceService.business.abstracts.InvoiceService;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.requests.CreateInvoiceRequest;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.requests.UpdateInvoiceRequest;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.responses.CreatedInvoiceResponse;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.responses.GetAllInvoicesResponse;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.responses.GetInvoiceByIdResponse;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.responses.UpdatedInvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/invoiceservice/api/v1/invoices")
public class InvoicesController {

    private final InvoiceService invoiceService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedInvoiceResponse add(CreateInvoiceRequest createInvoiceRequest) {
        return invoiceService.save(createInvoiceRequest);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedInvoiceResponse update(UpdateInvoiceRequest updateInvoiceRequest) {
        return invoiceService.update(updateInvoiceRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        invoiceService.delete(id);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetInvoiceByIdResponse get(@PathVariable int id) {
        return invoiceService.getById(id);
    }

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllInvoicesResponse> getAll() {
        return invoiceService.getAll();
    }
}
