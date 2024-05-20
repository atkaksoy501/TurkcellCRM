package com.turkcell.crm.customerService.entities.concretes;

import com.turkcell.crm.customerService.core.entities.BaseEntity;
import com.turkcell.crm.customerService.entities.concretes.enums.AddressType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "addresses")
@SequenceGenerator(
        name = "base_sequence_generator",
        sequenceName = "address_sequence",
        allocationSize = 1
)
public class Address extends BaseEntity<Integer> {
    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "street")
    private String street;

    @Column(name = "detail")
    private String detail;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "type")
    private AddressType type;

    @Column(name = "title")
    private String title;

    @Column(name = "door_number")
    private int doorNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
