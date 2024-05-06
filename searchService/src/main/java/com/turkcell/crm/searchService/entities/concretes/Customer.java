package com.turkcell.crm.searchService.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "customers")
public class Customer {
    private int id;

    @Field(name = "createDate")
    private LocalDateTime createdDate;

    @Field(name = "updateDate")
    private LocalDateTime updatedDate;

    @Field(name = "deleteDate")
    private LocalDateTime deletedDate;

    @Field(name = "active")
    private Boolean active;

    @Field(name="email")
    private String email;

    @Field(name = "first_name")
    private String firstName;

    @Field(name = "middle_name")
    private String middleName;

    @Field(name = "last_name")
    private String lastName;

    @Field(name = "birth_date")
    private LocalDate birthDate;

//    @Field(name = "gender")
//    private char gender;

    @Field(name = "father_name")
    private String fatherName;

    @Field(name = "mother_name")
    private String motherName;

    @Field(name = "mother_maiden_name")
    private String motherMaidenName;

    @Field(name = "national_id")
    private String nationalId;

    @Field(name = "mobile_phone_number")
    private String mobilePhoneNumber;

    @Field(name = "home_phone_number")
    private String homePhoneNumber;

//    private List<Address> addresses;
//
//    private List<Account> accounts;
}
