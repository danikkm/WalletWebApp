package com.danikkk.walletWebApp.repositories;

import com.danikkk.walletWebApp.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    User findFirstByUsername(String name);

    Optional<User> findById(String id);

    User findByEmail(String email);

    List<User> findAllByOrderById();

    @Query("{'accounts._id':?0}")
    User findByAccountId(String id);

}

