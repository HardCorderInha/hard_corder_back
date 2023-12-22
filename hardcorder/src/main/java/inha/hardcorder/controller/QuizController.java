package inha.hardcorder.controller;

import inha.hardcorder.dto.CategoryDto;
import inha.hardcorder.dto.QuizDto;
import inha.hardcorder.service.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("/api/quiz")
    public ResponseEntity<QuizDto> getQuiz(@RequestBody CategoryDto categoryDto) {
        List<QuizDto> quizByCategory = quizService.getQuizByCategory(categoryDto);
        Collections.shuffle(quizByCategory); // 무작위 추출 위함
        log.info("quiz 생성");
        return ResponseEntity.ok(quizByCategory.get(0));
    }
}
