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

//    @Override
//    public List<Account> findAccountsByUsername(String username) {
//        return userRepository.findAccountsByUsername(username);
//    }

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
//        userRepository.insert()
//        Update update = new Update();
//        update.addToSet("users.accounts", account);
//        Criteria criteria = Criteria.where("_id").is(id);
//        MongoTemplate mongoTemplate = null;
//        mongoTemplate.updateFirst(Query.query(criteria), update, "users");

//        Query query = new Query(Criteria.where("username").is(username));
//        Update update = new Update().set("accounts", account);
//        this.mongoTemplate.findAndModify(query, update, User.class);
        Query pQuery = new Query();
        Criteria pCriteria = Criteria.where("username").is(username);
        pQuery.addCriteria(pCriteria);
        Update pUpdate = new Update();
        pUpdate.push("accounts", account);
        this.mongoTemplate.updateFirst(pQuery, pUpdate, User.class);
    }
}
