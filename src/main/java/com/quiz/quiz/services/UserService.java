package com.quiz.quiz.services;
import com.quiz.quiz.repository.UserRepository;
import com.quiz.quiz.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserModel register(UserModel user) {
        return userRepository.save(user);
    }

    public UserModel login(String login, String password) {
        UserModel user = userRepository.findByLogin(login);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}