package inha.hardcorder.service;

import inha.hardcorder.domain.Member;
import inha.hardcorder.dto.MemberDto;
import inha.hardcorder.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    MemberRepository memberRepository;

    public String login(MemberDto memberDto) {
        Optional<Member> byEmailAndPassword = memberRepository.findByEmailAndPassword(memberDto.getEmail(), memberDto.getPassword());
        if(byEmailAndPassword.isEmpty()){
            return null;
        }else{
            return byEmailAndPassword.get().getEmail();
        }
    }
}
