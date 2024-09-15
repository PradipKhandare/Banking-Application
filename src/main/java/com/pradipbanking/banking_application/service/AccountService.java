package com.pradipbanking.banking_application.service;

import com.pradipbanking.banking_application.dto.AccountDto;

public interface AccountService {

    AccountDto createAccount(AccountDto account);

    AccountDto getAccountById(Long id);

    AccountDto deposite(Long id, double amount);
}
