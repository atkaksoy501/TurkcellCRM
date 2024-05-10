package com.turkcell.crm.customerService.entities.concretes;


import com.turkcell.crm.customerService.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity<Integer> {
    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

//    @ElementCollection
//    @CollectionTable(name = "account_ids", joinColumns = @JoinColumn(name = "customer_id"))
//    @Column(name = "account_id")
//    private List<Integer> accountIds;

    @OneToOne
    @JoinColumn(name = "individual_customer_id", referencedColumnName = "id")
    private IndividualCustomer individualCustomer;

    @OneToOne
    @JoinColumn(name = "business_customer_id", referencedColumnName = "id")
    private BusinessCustomer businessCustomer;

}
