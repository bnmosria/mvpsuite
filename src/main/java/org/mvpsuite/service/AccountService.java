package org.mvpsuite.service;

import lombok.extern.slf4j.Slf4j;
import org.mvpsuite.repository.AccountRepository;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void addAccount() {
    }
}
