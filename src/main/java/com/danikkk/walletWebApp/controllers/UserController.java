package com.danikkk.walletWebApp.controllers;

import com.danikkk.walletWebApp.models.Account;
import com.danikkk.walletWebApp.models.User;
import com.danikkk.walletWebApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
    public Collection<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/users/username/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        System.out.println(userService.findFirstByUsername(username));
        return userService.findFirstByUsername(username);
    }

    @GetMapping(value = "/accounts/{username}")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
    public List<Account> getAccountsByUsername(@PathVariable("username") String username) {
        return userService.findAllAccountsByUsername(username);
    }

    @GetMapping(value = "/users/accountId/{accountId}")
    public User getUserByAccountId(@PathVariable("accountId") String id) {
        return userService.findUserByAccountId(id);
    }

    @GetMapping(value = "/users/email/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
        return userService.findByEmail(email);
    }

    @GetMapping(value = "/users/id/{id}")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
    public User getUserById(@PathVariable("id") String id) {
        System.out.println(id);
        return userService.findFirstById(id);
    }

    @GetMapping(value = "/users/orderById")
    public List<User> findAllByOrderById() {
        return userService.findAllByOrderById();
    }

    @PostMapping(value = "/users")
    public ResponseEntity<?> saveOrUpdateUser(@RequestBody User user) {
        userService.saveOrUpdateUser(user);
        return new ResponseEntity<>("User added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/users/{username}")
    public void deleteUser(@PathVariable String username) {
        userService.deleteUser(userService.findFirstByUsername(username).getId());
    }

    @PutMapping(value = "/users/{username}")
    public ResponseEntity<?> addAccountToUser(@RequestBody @Valid Account account, @PathVariable("username") String username) {
        userService.putAccountInUserAccounts(username, account);
        return new ResponseEntity<>("Account added successfully", HttpStatus.OK);
    }

}
