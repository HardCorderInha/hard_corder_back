package inha.hardcorder.controller;

import inha.hardcorder.dto.MemberDto;
import inha.hardcorder.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@CrossOrigin
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/api/login")
    public ResponseEntity login(@RequestBody MemberDto memberDto, HttpSession httpSession) {
        String login = loginService.login(memberDto);
        if (login.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            httpSession.setAttribute("login", login);
            return ResponseEntity.ok(login);
        }
    }

    @PostMapping("/api/logout")
    public ResponseEntity logout(HttpSession httpSession) {
        if (httpSession != null) {
            httpSession.invalidate();
        }
        return ResponseEntity.ok().build();
    }

}
