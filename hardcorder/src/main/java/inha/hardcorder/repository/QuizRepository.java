package inha.hardcorder.repository;

import inha.hardcorder.domain.Quiz;
import inha.hardcorder.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}