package inha.hardcorder.dto;

import inha.hardcorder.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
    private Long id;
    private String email;
    private String password;
    private Long point;
    private Long count;

    public static MemberDto toDTO(Member entity){
        return MemberDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .point(entity.getPoint())
                .count(entity.getCount())
                .build();
    }
}
