package com.turkcell.crm.accountService.accountService.entities.concretes;

import com.turkcell.crm.accountService.accountService.core.entities.BaseEntity;
import com.turkcell.crm.accountService.accountService.entities.enums.AccountStatus;
import com.turkcell.crm.accountService.accountService.entities.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "address_id")
    private int addressId;

    @ElementCollection
    @CollectionTable(name = "product_ids", joinColumns = @JoinColumn(name = "account_id"))
    @Column(name = "products")
    private List<Integer> productIds;

}
