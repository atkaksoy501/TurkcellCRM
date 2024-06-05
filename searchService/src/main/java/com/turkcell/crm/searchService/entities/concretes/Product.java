package com.turkcell.crm.searchService.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "product")
public class Product {

    @Id
    private int id;

    @Field(name="name")
    private String name;

    @Field(name="description")
    private String description;

    @Field(name="price")
    private double price;

    @Field(name="stock_amount")
    private int stockAmount;
}
