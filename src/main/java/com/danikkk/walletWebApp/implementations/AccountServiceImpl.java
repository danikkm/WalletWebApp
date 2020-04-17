package com.danikkk.walletWebApp.implementations;

import com.danikkk.walletWebApp.models.Account;
import com.danikkk.walletWebApp.repositories.AccountRepository;
import com.danikkk.walletWebApp.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> findByName(String name) {
        return accountRepository.findByName(name);
    }

    @Override
    public Account findByUserId(String userId) {
        return accountRepository.findByUserId(userId);
    }

    @Override
    public Optional<Account> findById(String id) {
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> findAllByOrderById() {
        return accountRepository.findAllByOrderById();
    }

    @Override
    public void saveOrUpdateAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }
}
