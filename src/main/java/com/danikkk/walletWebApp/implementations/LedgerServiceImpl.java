package com.danikkk.walletWebApp.implementations;

import com.danikkk.walletWebApp.models.Account;
import com.danikkk.walletWebApp.models.Ledger;
import com.danikkk.walletWebApp.models.Subcategory;
import com.danikkk.walletWebApp.repositories.LedgerRepository;
import com.danikkk.walletWebApp.services.LedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LedgerServiceImpl implements LedgerService {

    @Autowired
    private LedgerRepository ledgerRepository;

    @Override
    public List<Ledger> findAll() {
        return ledgerRepository.findAll();
    }

    @Override
    public Optional<Ledger> findById(String id) {
        return ledgerRepository.findById(id);
    }

    @Override
    public List<Ledger> findByTransactionType(String transactionType) {
        return ledgerRepository.findByTransactionType(transactionType);
    }

    @Override
    public List<Ledger> findByTransactionTypeAndAmountGreaterThanEqual(String transactionType, Double greaterThan) {
        return ledgerRepository.findByTransactionTypeAndAmountGreaterThanEqual(transactionType, greaterThan);
    }

    @Override
    public List<Ledger> findByTransactionTypeAndSubcategory(String transactionType, Subcategory subcategory) {
        return ledgerRepository.findByTransactionTypeAndSubcategory(transactionType, subcategory);
    }


    @Override
    public List<Ledger> findByTransactionTypeAndAccount(String transactionType, Account account) {
        return ledgerRepository.findByTransactionTypeAndAccount(transactionType, account);
    }

    @Override
    public List<Ledger> findBySubcategory(Subcategory subcategory) {
        return ledgerRepository.findBySubcategory(subcategory);
    }

    @Override
    public List<Ledger> findByAccount(Account account) {
        return ledgerRepository.findByAccount(account);
    }

    @Override
    public List<Ledger> findAllByOrderByDate() {
        return ledgerRepository.findAllByOrderByDate();
    }

    @Override
    public void saveOrUpdateLedger(Ledger ledger) {
        ledgerRepository.save(ledger);
    }

    @Override
    public void deleteLedger(String id) {
        ledgerRepository.deleteById(id);
    }
}
