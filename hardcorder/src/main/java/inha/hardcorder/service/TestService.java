package inha.hardcorder.service;

import inha.hardcorder.domain.Test;
import inha.hardcorder.dto.TestDto;
import inha.hardcorder.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestService {
    @Autowired
    TestRepository testRepository;

    public Long postTest(TestDto test) {
        Test willSaved = new Test(test);
        Test saved = testRepository.save(willSaved);
        return saved.getId();
    }

    public TestDto getTest(Long id) {
        Optional<Test> byId = testRepository.findById(id);
        return new TestDto((byId.get()));
    }
}
