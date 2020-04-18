package com.danikkk.walletWebApp.services;

import com.danikkk.walletWebApp.models.Account;
import com.danikkk.walletWebApp.models.Ledger;
import com.danikkk.walletWebApp.models.Subcategory;

import java.util.List;
import java.util.Optional;

public interface LedgerService {
    List<Ledger> findAll();

    Optional<Ledger> findById(String id);

    List<Ledger> findByTransactionType(String transactionType);

    List<Ledger> findByTransactionTypeAndAmountGreaterThanEqual(String transactionType, Double greaterThan);

    List<Ledger> findByTransactionTypeAndSubcategory(String transactionType, Subcategory subcategory);

    List<Ledger> findByTransactionTypeAndAccount(String transactionType, Account account);

    List<Ledger> findBySubcategory(Subcategory subcategory);

    List<Ledger> findByAccount(Account account);

    List<Ledger> findAllByOrderByDate();

    void saveOrUpdateLedger(Ledger ledger);

    void deleteLedger(String id);
    // TODO: add put methods
}
