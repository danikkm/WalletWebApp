package com.danikkk.walletWebApp.repositories;

import com.danikkk.walletWebApp.models.Account;
import com.danikkk.walletWebApp.models.Ledger;
import com.danikkk.walletWebApp.models.Subcategory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface LedgerRepository extends MongoRepository<Ledger, String> {
    Optional<Ledger> findById(String id);

    List<Ledger> findByTransactionType(String transactionType);

    List<Ledger> findByTransactionTypeAndAmountGreaterThanEqual(String transactionType, Double greaterThan);

    List<Ledger> findByTransactionTypeAndSubcategory(String transactionType, Subcategory subcategory);

    List<Ledger> findByTransactionTypeAndAccount(String transactionType, Account account);

    List<Ledger> findBySubcategory(Subcategory subcategory);

    List<Ledger> findByAccount(Account account);

    List<Ledger> findAllByOrderByDate();
}

