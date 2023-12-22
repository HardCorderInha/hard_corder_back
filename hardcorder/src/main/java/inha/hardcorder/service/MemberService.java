package inha.hardcorder.service;


import inha.hardcorder.domain.Member;
import inha.hardcorder.dto.MemberDto;
import inha.hardcorder.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static inha.hardcorder.dto.MemberDto.toDTO;

@Service
@RequiredArgsConstructor
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public MemberDto createMember(MemberDto memberDto){

        Member member = Member.toEntity(memberDto);
        member.setPoint((long)100);
        member.setCount((long)0);
        Member reMember = memberRepository.save(member);
        return toDTO(reMember);
    }

    public  List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public MemberDto getMemberById(Long id){
        return toDTO(memberRepository.findById(id).orElseThrow());
    }

    public Member updateMember(Long id, MemberDto memberDto){
        Member member = Member.toEntity(getMemberById(id));
        member.setEmail(memberDto.getEmail());
        member.setPassword(memberDto.getPassword());
        member.setPoint(memberDto.getPoint());
        member.setCount(memberDto.getCount());
        return memberRepository.save(member);
    }

    public Long login(MemberDto memberDto, HttpSession httpSession) {
        Optional<Member> byEmailAndPassword = memberRepository.findByEmailAndPassword(memberDto.getEmail(), memberDto.getPassword());
        if(byEmailAndPassword.isEmpty()){
            return null;
        }else{
            return byEmailAndPassword.get().getId();
        }
    }


    public MemberDto updateMemberPoint(Long id, Long point) {
        Optional<Member> byId = memberRepository.findById(id);
        byId.get().setPoint(byId.get().getPoint()+point);
        Member save = memberRepository.save(byId.get());
        return toDTO(save);
    }

    public MemberDto updateMemberCount(Long id, Long count) {
        Optional<Member> byId = memberRepository.findById(id);
        byId.get().setCount(byId.get().getCount()+count);
        Member save = memberRepository.save(byId.get());
        return toDTO(save);
    }

    public MemberDto findByEmail(String login) {
        Optional<Member> byEmail = memberRepository.findByEmail(login);
        if(byEmail.isEmpty()){
            return null;
        }else{
            return MemberDto.toDTO(byEmail.get());
        }
    }

    public MemberDto findById(Long memberId) {
        Optional<Member> byId = memberRepository.findById(memberId);
        if(byId.isEmpty()){
            return null;
        }else{
            return MemberDto.toDTO(byId.get());
        }
    }
}
