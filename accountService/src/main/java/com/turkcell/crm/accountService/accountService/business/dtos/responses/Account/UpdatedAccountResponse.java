package com.turkcell.crm.accountService.accountService.business.dtos.responses.Account;

import com.turkcell.crm.accountService.accountService.entities.enums.AccountStatus;
import com.turkcell.crm.accountService.accountService.entities.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedAccountResponse {

    private AccountStatus status;

    private String accountNumber;

    private String accountName;

    private AccountType accountType;

    private LocalDateTime updatedDate;

    private int customerId;

    private List<Integer> productIds;

}
