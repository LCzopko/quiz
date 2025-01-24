package com.quiz.quiz.controller;

import com.quiz.quiz.model.QuizModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class QuizController {

    private List<QuizModel> allQuestions = Arrays.asList(
            new QuizModel("What does cybersecurity protect?", new String[]{"A) Physical health", "B) Natural disasters", "C) Digital systems and data", "D) Transportation networks"}, 2),
            new QuizModel("Which of these is an example of a strong password?", new String[]{"A) 123456", "B) P@ssw0rd123", "C) password", "D) abc123"}, 1),
            new QuizModel("What is the primary purpose of a firewall?", new String[]{"A) To block unauthorized access", "B) To provide faster internet speeds", "C) To store passwords", "D) To clean viruses from a computer"}, 0),
            new QuizModel("What does \"phishing\" mean in cybersecurity?", new String[]{"A) Coding a program", "B) Watching online videos", "C) Downloading free games", "D) Scamming people to steal personal information"}, 3),
            new QuizModel("What is a virus in computer terms?", new String[]{"A) A hardware issue", "B) A part of the operating system", "C) A program that harms your computer", "D) A file format"}, 2),
            new QuizModel("Which of these is a common sign of a phishing email?", new String[]{"A) Correct grammar and spelling", "B) Suspicious links or attachments", "C) Sent by a friend", "D) No subject line"}, 1),
            new QuizModel("Why is it important to update software regularly?", new String[]{"A) To fix security vulnerabilities", "B) To reduce computer weight", "C) To increase battery life", "D) To change screen resolution"}, 0),
            new QuizModel("What does \"two-factor authentication\" add to your account?", new String[]{"A) A new username", "B) Faster login speed", "C) Extra security layer", "D) A backup email"}, 2),
            new QuizModel("What is an example of personal information you should protect online?", new String[]{"A) Your home address", "B) Favorite movie", "C) Pet’s name", "D) Preferred color"}, 0),
            new QuizModel("Which device is considered part of the Internet of Things (IoT)?", new String[]{"A) Desktop computer", "B) Smartphone", "C) Printer", "D) Smart thermostat"}, 3)
            // Add more questions as needed
    );

    @GetMapping("/api/questions")
    public List<QuizModel> getQuestions() {
        Collections.shuffle(allQuestions);
        return allQuestions.stream().limit(10).collect(Collectors.toList());
    }
}