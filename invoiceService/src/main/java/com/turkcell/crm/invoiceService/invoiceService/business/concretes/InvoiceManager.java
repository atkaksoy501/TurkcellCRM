package com.turkcell.crm.invoiceService.invoiceService.business.concretes;

import com.turkcell.crm.invoiceService.invoiceService.business.abstracts.InvoiceService;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.requests.CreateInvoiceRequest;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.requests.UpdateInvoiceRequest;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.responses.CreatedInvoiceResponse;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.responses.GetAllInvoicesResponse;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.responses.GetInvoiceByIdResponse;
import com.turkcell.crm.invoiceService.invoiceService.business.dtos.responses.UpdatedInvoiceResponse;
import com.turkcell.crm.invoiceService.invoiceService.core.utilities.mapping.ModelMapperService;
import com.turkcell.crm.invoiceService.invoiceService.dataAccess.abstracts.InvoiceRepository;
import com.turkcell.crm.invoiceService.invoiceService.entities.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class InvoiceManager implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public CreatedInvoiceResponse save(CreateInvoiceRequest createInvoiceRequest) {

        Invoice invoice = modelMapperService.forRequest().map(createInvoiceRequest, Invoice.class);
        invoice.setCreatedDate(LocalDateTime.now());

        invoiceRepository.save(invoice);

        return modelMapperService.forResponse().map(invoice, CreatedInvoiceResponse.class);
    }

    @Override
    public UpdatedInvoiceResponse update(UpdateInvoiceRequest updateInvoiceRequest) {

        Invoice invoice = invoiceRepository.findById(updateInvoiceRequest.getId()).orElse(null);

        modelMapperService.forUpdate().map(updateInvoiceRequest, invoice);
        invoice.setUpdatedDate(LocalDateTime.now());

        invoiceRepository.save(invoice);

        return modelMapperService.forResponse().map(invoice, UpdatedInvoiceResponse.class);
    }

    @Override
    public void delete(int id) {

        Invoice invoice = invoiceRepository.findById(id).orElse(null);
        invoice.setDeletedDate(LocalDateTime.now());
        invoice.setActive(false);

        invoiceRepository.save(invoice);
    }

    @Override
    public GetInvoiceByIdResponse getById(int id) {

        Invoice invoice = invoiceRepository.findById(id).orElse(null);

        return modelMapperService.forResponse().map(invoice, GetInvoiceByIdResponse.class);
    }

    @Override
    public List<GetAllInvoicesResponse> getAll() {

        List<Invoice> invoices = invoiceRepository.findAll().stream().filter(Invoice::isActive).toList();

        return invoices.stream().map(invoice -> modelMapperService.forResponse().map(invoice, GetAllInvoicesResponse.class)).toList();
    }
}
