package com.danikkk.walletWebApp.services;

import com.danikkk.walletWebApp.models.Account;
import com.danikkk.walletWebApp.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    User findFirstByUsername(String username);

    Optional<User> findById(String id);

    User findByEmail(String email);

    List<User> findAllByOrderById();
    void saveOrUpdateUser(User user);

    void deleteUser(String id);

    void putAccountInUserAccounts(String username, Account account);
}
