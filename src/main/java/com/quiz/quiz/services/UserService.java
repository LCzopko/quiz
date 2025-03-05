//package com.quiz.quiz.services;
//import com.quiz.quiz.repository.UserRepository;
//import com.quiz.quiz.model.UserModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    public UserModel register(UserModel user) {
//        return userRepository.save(user);
//    }
//
//    public UserModel login(String login, String password) {
//        UserModel user = userRepository.findByLogin(login);
//        if (user != null && user.getPassword().equals(password)) {
//            return user;
//        }
//        return null;
//    }
//}

package com.quiz.quiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quiz.quiz.model.UserModel;
import com.quiz.quiz.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserModel register(UserModel user) {
        if (userRepository.findByLogin(user.getLogin()) != null) {
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(user);
    }
    public boolean login(String login, String password) {
        UserModel user = userRepository.findByLogin(login);
        if (user == null) {
            System.out.println("User not found for login: " + login);
            return false;
        }
        boolean passwordMatches = user.getPassword().equals(password);
        if (!passwordMatches) {
            System.out.println("Password mismatch for user: " + login);
        }
        return passwordMatches;
    }
}