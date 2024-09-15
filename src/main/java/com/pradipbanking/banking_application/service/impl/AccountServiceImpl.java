package com.pradipbanking.banking_application.service.impl;

import com.pradipbanking.banking_application.dto.AccountDto;
import com.pradipbanking.banking_application.entity.Account;
import com.pradipbanking.banking_application.mapper.AccountMapper;
import com.pradipbanking.banking_application.repository.AccountRepository;
import com.pradipbanking.banking_application.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto account) {
        Account account1 = AccountMapper.mapToAccount(account);
        Account savedAccount = accountRepository.save(account1);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
      Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
      AccountDto accountDto = AccountMapper.mapToAccountDto(account);
      return accountDto;
    }

    @Override
    public AccountDto deposite(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
       double total = account.getBalance() + amount;
       account.setBalance(total);
      Account savedAccount = accountRepository.save(account);
      return AccountMapper.mapToAccountDto(savedAccount);
    }
}