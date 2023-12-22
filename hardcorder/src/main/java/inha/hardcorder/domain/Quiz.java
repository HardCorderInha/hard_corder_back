package inha.hardcorder.domain;

import inha.hardcorder.domain.mapping.MemberQuiz;
import inha.hardcorder.domain.mapping.QuizCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String answer;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<MemberQuiz> memberQuizList = new ArrayList<>();

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<QuizCategory> quizCategoryList = new ArrayList<>();
}
