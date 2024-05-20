package com.turkcell.crm.invoiceService.invoiceService.business.abstracts;

import com.turkcell.crm.invoiceService.invoiceService.business.dtos.requests.CreateInvoiceRequest;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.requests.UpdateInvoiceRequest;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.responses.CreatedInvoiceResponse;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.responses.GetAllInvoicesResponse;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.responses.GetInvoiceByIdResponse;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.responses.UpdatedInvoiceResponse;

import java.util.List;

public interface InvoiceService {

    CreatedInvoiceResponse save(CreateInvoiceRequest createInvoiceRequest);
    UpdatedInvoiceResponse update(UpdateInvoiceRequest updateInvoiceRequest);
    void delete(int id);
    GetInvoiceByIdResponse getById(int id);
    List<GetAllInvoicesResponse> getAll();
}
