package com.turkcell.crm.customerService.business.abstracts;

import com.turkcell.crm.customerService.business.dtos.requests.Account.CreateAccountRequest;
import com.turkcell.crm.customerService.business.dtos.requests.Account.UpdateAccountRequest;
import com.turkcell.crm.customerService.business.dtos.responses.Account.CreatedAccountResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Account.GetAccountResponseById;
import com.turkcell.crm.customerService.business.dtos.responses.Account.GetAllAccountResponse;
import com.turkcell.crm.customerService.business.dtos.responses.Account.UpdatedAccountResponse;

import java.util.List;

public interface AccountService {
    GetAccountResponseById getAccountById(int id);
    List<GetAllAccountResponse> getAll();
    CreatedAccountResponse add(CreateAccountRequest createAccountRequest);
    UpdatedAccountResponse update(UpdateAccountRequest updateAccountRequest);
    void delete(int id);

}
