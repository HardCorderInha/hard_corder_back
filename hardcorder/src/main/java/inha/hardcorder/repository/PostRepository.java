package inha.hardcorder.repository;

import inha.hardcorder.domain.Post;
import inha.hardcorder.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}