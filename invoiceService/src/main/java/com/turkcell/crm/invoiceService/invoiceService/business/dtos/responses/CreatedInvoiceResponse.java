package com.turkcell.crm.invoiceService.invoiceService.business.dtos.responses;

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
public class CreatedInvoiceResponse {

    private int id;

    private int orderId;

    private int accountId;

    private List<Integer> productIds;

    private double totalPrice;
}
