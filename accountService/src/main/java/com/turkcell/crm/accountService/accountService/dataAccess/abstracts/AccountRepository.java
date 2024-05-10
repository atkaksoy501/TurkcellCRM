package com.turkcell.crm.accountService.accountService.dataAccess.abstracts;

import com.turkcell.crm.accountService.accountService.entities.concretes.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
