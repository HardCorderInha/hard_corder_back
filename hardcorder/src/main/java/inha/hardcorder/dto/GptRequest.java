package inha.hardcorder.dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class GptRequest {
    private String type;
    private String content;
}
