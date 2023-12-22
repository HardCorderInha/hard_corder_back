package inha.hardcorder.service;

import inha.hardcorder.repository.QuizRepository;
import inha.hardcorder.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;
}
