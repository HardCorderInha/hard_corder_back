package inha.hardcorder.repository;

import inha.hardcorder.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByQuizCategoryListCategoryTypeAndQuizCategoryListCategoryLevel(String type, String level);
}