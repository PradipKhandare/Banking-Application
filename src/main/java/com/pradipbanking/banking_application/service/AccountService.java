package com.pradipbanking.banking_application.service;

import com.pradipbanking.banking_application.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto account);

    AccountDto getAccountById(Long id);

    AccountDto deposite(Long id, double amount);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);
}
