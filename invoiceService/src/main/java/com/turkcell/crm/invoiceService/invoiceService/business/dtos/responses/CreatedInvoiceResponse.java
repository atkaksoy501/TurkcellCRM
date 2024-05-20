package com.turkcell.crm.invoiceService.invoiceService.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedInvoiceResponse {

    private int id;

    private int orderId;
}
