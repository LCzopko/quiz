package com.quiz.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quiz.quiz.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByLogin(String login);
}