package com.turkcell.crm.customerService.entities.concretes;

import com.turkcell.crm.customerService.core.entities.BaseEntity;
import com.turkcell.crm.customerService.core.enums.AccountStatus;
import com.turkcell.crm.customerService.core.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "accounts")
public class Account extends BaseEntity<Integer> {
    @Column(name = "status")
    private AccountStatus status;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_type")
    private AccountType accountType;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
