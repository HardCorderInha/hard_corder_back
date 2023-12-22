package inha.hardcorder.controller;

import inha.hardcorder.domain.Member;
import inha.hardcorder.dto.MemberDto;
import inha.hardcorder.repository.MemberRepository;
import inha.hardcorder.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    // post- createMember(point 100), login , id-count,point 반환 ,
    @PostMapping
    public ResponseEntity<MemberDto> create(@RequestBody MemberDto memberDto) {
        MemberDto member = memberService.createMember(memberDto);
        log.info("create done "+member.getId());
        return ResponseEntity.ok(member);
    }

    @GetMapping("/info")
    public ResponseEntity<MemberDto> getMemberInfo(HttpSession httpSession) {
        String login = (String) httpSession.getAttribute("login");
        MemberDto byEmail = memberService.findByEmail(login);
        log.info("info done " + login);
        return ResponseEntity.ok(byEmail);
    }

    @GetMapping("/info/{memberId}")
    public ResponseEntity<MemberDto> getMemberInfo(@PathVariable Long memberId) {
        MemberDto byId = memberService.findById(memberId);
        log.info("info done " + byId.getId());
        return ResponseEntity.ok(byId);
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody MemberDto memberDto, HttpSession httpSession) {
        Long login = memberService.login(memberDto, httpSession);
        if (login == null) {
            return ResponseEntity.badRequest().build();
        } else {
            httpSession.setAttribute("login", login);
            log.info("로그인 성공 " + login);
            return ResponseEntity.ok(login);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity logout(HttpSession httpSession) {
        if (httpSession != null) {
            httpSession.invalidate();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/upPoint")
    public ResponseEntity<String> upPoint(HttpSession httpSession, @RequestBody Long point) {
        String login = (String) httpSession.getAttribute("login");
        Member member = memberRepository.findByEmail(login).orElseThrow();
        memberService.updateMemberPoint(member.getId(), point);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/upCount")
    public ResponseEntity<String> upCount(HttpSession httpSession, @RequestBody Long count) {
        String login = (String) httpSession.getAttribute("login");
        Member member = memberRepository.findByEmail(login).orElseThrow();
        memberService.updateMemberCount(member.getId(), count);
        return ResponseEntity.ok().build();
    }
}

