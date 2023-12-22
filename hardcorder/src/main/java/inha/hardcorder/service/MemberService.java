package inha.hardcorder.service;

import inha.hardcorder.repository.MemberRepository;
import inha.hardcorder.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;
}
