package com.danikkk.walletWebApp.controllers;

import com.danikkk.walletWebApp.services.UserService;
import com.danikkk.walletWebApp.models.User;
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
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/users/username/{userName}")
    public User getUserByUserName(@PathVariable("userName") String userName) {
        System.out.println(userService.findByUserName(userName));
        return userService.findByUserName(userName);
    }

    @GetMapping(value = "/users/email/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
        return userService.findByEmail(email);
    }

    @GetMapping(value = "/users/id/{id}")
    public Optional<User> getUserById(@PathVariable("id") String id) {
        return userService.findById(id);
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

    @DeleteMapping(value = "/users/{userName}")
    public void deleteUser(@PathVariable String userName) {
        userService.deleteUser(userService.findByUserName(userName).getId());
    }

}
