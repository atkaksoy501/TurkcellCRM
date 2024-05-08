package com.turkcell.crm.customerService.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "business_customers")
public class BusinessCustomer extends Customer {
    @Column(name = "business_customer_id", insertable = false, updatable = false)
    private Integer businessCustomerId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "tax_number")
    private String taxNumber;

    @Column(name = "work_phone")
    private String workPhone;

    @Column(name = "fax_number")
    private String faxNumber;
}
