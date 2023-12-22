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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // 알고, 자구, 디비 ,,
    private String level; // 상 중 하

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<QuizCategory> quizCategoryList = new ArrayList<>();
}
