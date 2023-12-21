package inha.hardcorder.controller;

import inha.hardcorder.dto.TestDto;
import inha.hardcorder.service.TestService;;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
public class TestController {
    @Autowired
    TestService testService;

    @PostMapping("api/test")
    public ResponseEntity<Long> postTest(@RequestBody TestDto test){
        Long id = testService.postTest(test);
        log.info("postTest done");
        return ResponseEntity.ok(id);
    }

    @GetMapping("api/test/{id}")
    public ResponseEntity<TestDto> GetTest(@PathVariable Long id){
        TestDto test = testService.getTest(id);
        log.info("getTest done");
        return ResponseEntity.ok(test);
    }
}
