package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Account;
import com.example.entity.Message;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // Account saveAccount (Account newAccount);

    Optional<Account> findByUsername(String account);

        Account findByUsernameAndPassword(String username, String password);
    

}
