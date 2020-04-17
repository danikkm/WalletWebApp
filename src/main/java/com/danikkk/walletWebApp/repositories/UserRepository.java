package com.danikkk.walletWebApp.repositories;

import com.danikkk.walletWebApp.models.Account;
import com.danikkk.walletWebApp.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String name);


    //    List<Account> findAccountsByUsername(String username);
//    @Query(value = "{'accounts.user_id': ?0}")
//    List<User> findAccountsByUsername(String username);
    List<User> findByAccounts_(String id);

    User findByEmail(String email);

    List<User> findAllByOrderById();

}

