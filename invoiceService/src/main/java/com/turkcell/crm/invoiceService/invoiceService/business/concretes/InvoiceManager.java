package com.turkcell.crm.invoiceService.invoiceService.business.concretes;

import com.turkcell.crm.invoiceService.invoiceService.business.abstracts.InvoiceService;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.requests.CreateInvoiceRequest;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.requests.UpdateInvoiceRequest;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.responses.CreatedInvoiceResponse;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.responses.GetAllInvoicesResponse;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.responses.GetInvoiceByIdResponse;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.responses.UpdatedInvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class InvoiceManager implements InvoiceService {
    @Override
    public CreatedInvoiceResponse save(CreateInvoiceRequest createInvoiceRequest) {
        return null;
    }

    @Override
    public UpdatedInvoiceResponse update(UpdateInvoiceRequest updateInvoiceRequest) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public GetInvoiceByIdResponse getById(int id) {
        return null;
    }

    @Override
    public List<GetAllInvoicesResponse> getAll() {
        return null;
    }
}
