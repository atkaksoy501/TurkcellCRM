package com.turkcell.crm.accountService.accountService.business.concretes;

import com.turkcell.crm.accountService.accountService.business.abstracts.AccountService;
import com.turkcell.crm.accountService.accountService.business.dtos.requests.Account.CreateAccountRequest;
import com.turkcell.crm.accountService.accountService.business.dtos.requests.Account.UpdateAccountRequest;
import com.turkcell.crm.accountService.accountService.business.dtos.responses.Account.CreatedAccountResponse;
import com.turkcell.crm.accountService.accountService.business.dtos.responses.Account.GetAccountResponseById;
import com.turkcell.crm.accountService.accountService.business.dtos.responses.Account.GetAllAccountResponse;
import com.turkcell.crm.accountService.accountService.business.dtos.responses.Account.UpdatedAccountResponse;
import com.turkcell.crm.accountService.accountService.business.rules.AccountBusinessRules;
import com.turkcell.crm.accountService.accountService.core.utilities.mapping.ModelMapperService;
import com.turkcell.crm.accountService.accountService.dataAccess.abstracts.AccountRepository;
import com.turkcell.crm.accountService.accountService.entities.concretes.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class AccountManager implements AccountService {
    private final ModelMapperService modelMapperService;
    private final AccountRepository accountRepository;
    private final AccountBusinessRules accountBusinessRules;
    @Override
    public GetAccountResponseById getAccountById(int id) {

        accountBusinessRules.accountMustExist(id);

        Account account = accountRepository.findById(id).orElse(null);
        return this.modelMapperService.forResponse().map(account, GetAccountResponseById.class);
    }

    @Override
    public List<GetAllAccountResponse> getAll() {

        List<Account> accounts = accountRepository.findAll().stream().filter(Account::isActive).toList();
        return accounts.stream().map(
                account -> this.modelMapperService.forResponse().map(account, GetAllAccountResponse.class)
        ).toList();
    }

    @Override
    public CreatedAccountResponse add(CreateAccountRequest createAccountRequest) {

        Account account = this.modelMapperService.forRequest().map(createAccountRequest, Account.class);
        account.setCreatedDate(LocalDateTime.now());
        Account savedAccount = accountRepository.save(account);
        return this.modelMapperService.forResponse().map(savedAccount, CreatedAccountResponse.class);
    }

    @Override
    public UpdatedAccountResponse update(UpdateAccountRequest updateAccountRequest) {

        accountBusinessRules.accountMustExist(updateAccountRequest.getId());

        Account account = accountRepository.findById(updateAccountRequest.getId()).orElse(null);
        modelMapperService.forUpdate().map(updateAccountRequest, account);
        account.setUpdatedDate(LocalDateTime.now());
        Account savedAccount = accountRepository.save(account);
        return this.modelMapperService.forResponse().map(savedAccount, UpdatedAccountResponse.class);
    }

    @Override
    public void delete(int id) {

        accountBusinessRules.accountMustExist(id);
        accountBusinessRules.checkIfAccountHasProducts(id);

        Account account = accountRepository.findById(id).orElse(null);
        account.setActive(false);
        account.setDeletedDate(LocalDateTime.now());
        accountRepository.save(account);
    }
}
