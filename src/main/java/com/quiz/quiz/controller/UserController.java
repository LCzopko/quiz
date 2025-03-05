//package com.quiz.quiz.controller;
//import com.quiz.quiz.model.UserModel;
//import com.quiz.quiz.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/register")
//    public UserModel register(@RequestBody UserModel user) {
//        return userService.register(user);
//    }
//
//    @PostMapping("/login")
//    public UserModel login(@RequestBody UserModel user) {
//        return userService.login(user.getLogin(), user.getPassword());
//    }
//}
package com.quiz.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.quiz.quiz.model.UserModel;
import com.quiz.quiz.services.UserService;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserModel> register(@RequestBody UserModel user) {
        UserModel registeredUser = userService.register(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserModel user) {
        System.out.println("Received login request for user: " + user.getLogin());
        boolean isAuthenticated = userService.login(user.getLogin(), user.getPassword());
        if (isAuthenticated) {
            System.out.println("Login successful for user: " + user.getLogin());
            return new ResponseEntity<>(Map.of("message", "Login successful"), HttpStatus.OK);
        } else {
            System.out.println("Invalid credentials for user: " + user.getLogin());
            return new ResponseEntity<>(Map.of("message", "Invalid credentials"), HttpStatus.UNAUTHORIZED);
        }
    }
}