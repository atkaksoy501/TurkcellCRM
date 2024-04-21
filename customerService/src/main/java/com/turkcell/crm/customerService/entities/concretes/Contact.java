package com.turkcell.crm.customerService.entities.concretes;

import com.turkcell.crm.customerService.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "contacts")
public class Contact extends BaseEntity<Integer> {
    @Column(name = "mobile_phone_number")
    private String mobilePhoneNumber;

    @Column(name = "home_phone_number")
    private String homePhoneNumber;

    @Column(name = "work_phone_number")
    private String workPhoneNumber;

    @Column(name = "fax_number")
    private String faxNumber;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
