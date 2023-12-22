package inha.hardcorder.domain;

import inha.hardcorder.domain.mapping.MemberQuiz;
import inha.hardcorder.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private Long point;
    private Long count;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberQuiz> memberQuizList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Post> postList = new ArrayList<>();

    public static Member toEntity(MemberDto dto){
        return Member.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .point(dto.getPoint())
                .count(dto.getCount())
                .build();
    }
}
