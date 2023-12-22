package inha.hardcorder.dto;

import inha.hardcorder.domain.Quiz;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {
    private String question;
    private String answer;
    private String options;
    public QuizDto(Quiz quiz) {
        this.question = quiz.getQuestion();
        this.answer = quiz.getAnswer();
        this.options = quiz.getOptions();
    }
}
