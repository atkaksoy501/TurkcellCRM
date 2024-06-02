package com.turkcell.crm.accountService.accountService.business.rules;

import com.turkcell.crm.accountService.accountService.business.messages.Messages;
import com.turkcell.crm.accountService.accountService.core.business.abstracts.MessageService;
import com.turkcell.crm.accountService.accountService.dataAccess.abstracts.AccountRepository;
import com.turkcell.crm.accountService.accountService.entities.concretes.Account;
import com.turkcell.crm.core.core.exceptions.types.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountBusinessRules {

    private final AccountRepository accountRepository;
    private final MessageService messageService;

    public void accountMustExist(int id) {
        if (!accountRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.AccountErrors.ACCOUNT_NOT_FOUND));
        }
    }

    public void checkIfAccountHasProducts(int id) {

        Account account = accountRepository.findById(id).orElse(null);
        if(account.getProductIds() != null) {
            throw new BusinessException(messageService.getMessage(Messages.AccountErrors.ACCOUNT_HAS_PRODUCTS));
        }
    }
}
