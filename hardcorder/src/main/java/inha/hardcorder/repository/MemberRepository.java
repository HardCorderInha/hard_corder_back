package inha.hardcorder.repository;

import inha.hardcorder.domain.Member;
import inha.hardcorder.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}