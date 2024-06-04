package com.turkcell.crm.invoiceService.invoiceService.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetInvoiceByIdResponse {

    private int id;

    private int orderId;

    private int accountId;

    private List<Integer> productIds;

    private double totalPrice;
}
