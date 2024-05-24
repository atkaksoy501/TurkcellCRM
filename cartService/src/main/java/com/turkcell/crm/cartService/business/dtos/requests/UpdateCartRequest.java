package com.turkcell.crm.cartService.business.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCartRequest {
    private int id;
    private int accountId;
    private Map<Integer, Integer> products; //<productId, quantity>
    private double totalPrice;
}
