package com.danikkk.walletWebApp.repositories;

import com.danikkk.walletWebApp.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUserName(String name);

    User findByEmail(String email);

    List<User> findAllByOrderById();
}
