package inha.hardcorder.controller;

import inha.hardcorder.dto.GptRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@CrossOrigin
public class GptController {
    @PostMapping("/api/gpt")
    public ResponseEntity<String> gpt(@RequestBody GptRequest request) {
        String url = "http://127.0.0.1:5000/api/gpt";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // JSON 데이터 설정
        String jsonBody = "{ \"type\": \"" + request.getType() + "\", \"content\": \"" + request.getContent() + "\" }";

        HttpEntity<String> requestEntity = new HttpEntity<>(jsonBody, headers);

        // RestTemplate 생성
        RestTemplate restTemplate = new RestTemplate();

        // POST 요청 보내기
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        // 응답 확인
        String responseBody = responseEntity.getBody();
        System.out.println("Response from Flask Server: " + responseBody);

        return ResponseEntity.ok(responseBody);
    }
}
