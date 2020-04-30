package com.danikkk.walletWebApp.repositories;

import com.danikkk.walletWebApp.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User findFirstByUsername(String name);

    User findFirstById(String id);

    User findByEmail(String email);

    List<User> findAllByOrderById();

    @Query("{'accounts._id':?0}")
    User findByAccountId(String id);

}

