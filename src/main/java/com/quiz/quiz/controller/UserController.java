package com.quiz.quiz.controller;
import com.quiz.quiz.model.UserModel;
import com.quiz.quiz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserModel register(@RequestBody UserModel user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public UserModel login(@RequestBody UserModel user) {
        return userService.login(user.getLogin(), user.getPassword());
    }
}