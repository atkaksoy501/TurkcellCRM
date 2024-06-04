package com.turkcell.crm.orderService.business.dtos.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateOrderRequest {

    private int addressId;

    private List<Integer> productIds;

    private int accountId;
}
