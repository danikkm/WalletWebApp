package com.danikkk.walletWebApp.services;

import com.danikkk.walletWebApp.models.Account;
import com.danikkk.walletWebApp.models.User;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> findAll();

    List<Account> findByName(String name);

    Account findByUserId(String userId);

    Optional<Account> findById(String id);

    List<Account> findAllByOrderById();

    void saveOrUpdateAccount(Account account);

    void deleteAccount(String id);
}
