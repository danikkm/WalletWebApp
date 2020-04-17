package com.danikkk.walletWebApp.services;

import com.danikkk.walletWebApp.models.Account;
import com.danikkk.walletWebApp.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    User findByUsername(String username);

//    List<Account> findAccountsByUsername(String username);

    User findByEmail(String email);

    Optional<User> findById(String id);

    List<User> findAllByOrderById();

    void saveOrUpdateUser(User user);

    void deleteUser(String id);
}
