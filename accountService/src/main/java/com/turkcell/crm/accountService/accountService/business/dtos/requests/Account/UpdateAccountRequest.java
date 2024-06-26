package com.turkcell.crm.accountService.accountService.business.dtos.requests.Account;

import com.turkcell.crm.accountService.accountService.entities.enums.AccountStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateAccountRequest {

    @NotNull
    private int id;

    @Size(min = 2, max = 50)
    private String accountName;

    private AccountStatus status;

    private List<Integer> productIds;
}
