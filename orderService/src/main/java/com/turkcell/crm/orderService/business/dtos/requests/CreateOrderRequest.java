package com.turkcell.crm.orderService.business.dtos.requests;


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
public class CreateOrderRequest {

    private double totalAmount;

    private int addressId;

    private List<Integer> productIds;

    private int accountId;
}
