package inha.hardcorder.repository;

import inha.hardcorder.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

    Optional<Member> findByEmailAndPassword(String email, String password);

    /* 기본정의
    Member findById(Long id);

    List<Member> findAll();

    Member save(Member member);

    void deleteById(Long id);
     */
}