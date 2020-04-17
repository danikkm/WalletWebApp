package com.danikkk.walletWebApp.controllers;

import com.danikkk.walletWebApp.models.Account;
import com.danikkk.walletWebApp.models.User;
import com.danikkk.walletWebApp.services.AccountService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@NoArgsConstructor
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/accounts")
    public List<Account> getAllAccounts() {
        return accountService.findAll();
    }

    @GetMapping(value = "/accounts/name/{name}")
    public List<Account> getAccountByName(@PathVariable("name") String name) {
        System.out.println(accountService.findByName(name));
        return accountService.findByName(name);
    }

    @GetMapping(value = "/accounts/id/{id}")
    public Optional<Account> getUserById(@PathVariable("id") String id) {
        return accountService.findById(id);
    }

    @GetMapping(value = "/accounts/orderById")
    public List<Account> findAllByOrderById() {
        return accountService.findAllByOrderById();
    }


    @PostMapping(value = "/accounts")
    public ResponseEntity<?> saveOrUpdateAccount(@RequestBody Account account) {
        accountService.saveOrUpdateAccount(account);
        return new ResponseEntity<>("Account added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/accounts/{id}")
    public void deleteUser(@PathVariable String id) {
        accountService.deleteAccount(id);
    }

}
