package com.danikkk.walletWebApp.repositories;

import com.danikkk.walletWebApp.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    User findFirstByUsername(String name);

    Optional<User> findById(String id);

    User findByEmail(String email);

    List<User> findAllByOrderById();

//    User putAccountInUserAccounts(int String, Account account);

}

