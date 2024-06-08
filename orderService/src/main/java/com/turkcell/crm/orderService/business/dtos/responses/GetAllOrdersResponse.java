package com.turkcell.crm.orderService.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllOrdersResponse {

    private int id;

    private double totalAmount;

    private GetAddressResponseById address;

    private List<Integer> productIds;

    private int accountId;
}
