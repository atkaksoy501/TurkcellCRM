package com.turkcell.crm.invoiceService.invoiceService.business.dtos.requests;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateInvoiceRequest {

    private int orderId;

    private int accountId;
}
