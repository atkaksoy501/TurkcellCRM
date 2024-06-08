package com.turkcell.crm.invoiceService.invoiceService.business.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateInvoiceRequest {

    private int id;

    private int orderId;

    private int accountId;
}
