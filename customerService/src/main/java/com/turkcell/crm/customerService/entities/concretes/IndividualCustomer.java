package com.turkcell.crm.customerService.entities.concretes;

import com.turkcell.crm.customerService.core.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "individual_customers")
public class IndividualCustomer extends Customer {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "mother_maiden_name")
    private String motherMaidenName;

    @Column(name = "national_id")
    private String nationalId;

    @Column(name = "mobile_phone_number")
    private String mobilePhoneNumber;

    @Column(name = "home_phone_number")
    private String homePhoneNumber;

}
