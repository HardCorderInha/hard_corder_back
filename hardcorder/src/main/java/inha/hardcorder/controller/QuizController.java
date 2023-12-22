package inha.hardcorder.controller;

import inha.hardcorder.service.QuizService;
import inha.hardcorder.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@CrossOrigin
public class QuizController {
    @Autowired
    QuizService quizService;
}
