package com.danikkk.walletWebApp.services;

import com.danikkk.walletWebApp.models.Account;
import com.danikkk.walletWebApp.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findFirstByUsername(String username);

    User findFirstById(String id);

    User findByEmail(String email);

    List<User> findAllByOrderById();

    void saveOrUpdateUser(User user);

    void deleteUser(String id);

    void putAccountInUserAccounts(String username, Account account);

    User findUserByAccountId(String id);

    List<Account> findAllAccountsByUsername(String username);
}
