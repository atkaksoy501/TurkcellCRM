package com.turkcell.crm.common.events.catalog;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductEvent {

    private int id;

    private String name;

    private String description;

    private double price;

    private int stockAmount;
}
