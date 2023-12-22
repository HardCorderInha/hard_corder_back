package inha.hardcorder.service;

import inha.hardcorder.domain.Quiz;
import inha.hardcorder.dto.CategoryDto;
import inha.hardcorder.dto.QuizDto;
import inha.hardcorder.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;

    public List<QuizDto> getQuizByCategory(CategoryDto categoryDto) {
        List<Quiz> quizList = quizRepository.
                findByQuizCategoryListCategoryTypeAndQuizCategoryListCategoryLevel(
                        categoryDto.getType(), categoryDto.getLevel());

        List<QuizDto> quizDtoList = new ArrayList<>();
        for (int i = 0; i < quizList.size(); i++) {
            quizDtoList.add(new QuizDto(quizList.get(i)));
        }
        return quizDtoList;
    }
}
