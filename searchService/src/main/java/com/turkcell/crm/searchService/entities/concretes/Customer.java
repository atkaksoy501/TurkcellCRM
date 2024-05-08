package com.turkcell.crm.searchService.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "customers")
public class Customer {
    private int id;

    @Field(name="email")
    private String email;

    @Field(name = "first_name")
    private String firstName;

    @Field(name = "last_name")
    private String lastName;

    @Field(name = "national_id")
    private String nationalityId;

    @Field(name = "mobile_phone_number")
    private String mobilePhoneNumber;

    @Field(name = "account_number")
    private String accountNumber;

    @Field(name = "order_number")
    private String orderNumber;
}
