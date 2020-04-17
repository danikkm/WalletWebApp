package com.danikkk.walletWebApp.repositories;

import com.danikkk.walletWebApp.models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.nio.channels.AcceptPendingException;
import java.util.List;

public interface AccountRepository extends MongoRepository<Account, String> {
    List<Account> findByName(String name);

    Account findByUserId(String userId);

    List<Account> findAllByOrderById();
}
