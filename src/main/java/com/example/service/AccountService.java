package com.example.service;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

import java.util.*;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean isUsernameExist(String username) {
        return accountRepository.findByUsername(username).isPresent();
    }

    public Account saveAccount(Account newAccount) {
        return accountRepository.save(newAccount);
    }

    List<Account> accounts = new ArrayList<Account>();


    public Account getAccountByUsernameAndPassword(String username, String password) {
        return accountRepository.findByUsernameAndPassword(username, password);
    }
    
    


}
