package com.danikkk.walletWebApp.implementations;

import com.danikkk.walletWebApp.models.Account;
import com.danikkk.walletWebApp.models.User;
import com.danikkk.walletWebApp.repositories.UserRepository;
import com.danikkk.walletWebApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    MongoOperations mongoTemplate;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findFirstByUsername(String username) {
        return userRepository.findFirstByUsername(username);
    }


    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAllByOrderById() {
        return userRepository.findAllByOrderById();
    }

    @Override
    public void saveOrUpdateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void putAccountInUserAccounts(String username, Account account) {
        Query pQuery = new Query();
        Criteria pCriteria = Criteria.where("username").is(username);
        pQuery.addCriteria(pCriteria);
        Update pUpdate = new Update();
        pUpdate.push("accounts", account);
        this.mongoTemplate.updateFirst(pQuery, pUpdate, User.class);
    }

    @Override
    public User findUserByAccountId(String id) {
        return userRepository.findByAccountId(id);
    }

    @Override
    public List<Account> findAllAccountsByUsername(String username) {
        return userRepository.findFirstByUsername(username).getAccounts();
    }
}
