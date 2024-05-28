package com.turkcell.crm.cartService.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedCartResponse {
    private String accountId;
    private Map<Integer, Integer> products; //<productId, quantity>
    private double totalPrice;
}
