package inha.hardcorder.dto;

import inha.hardcorder.domain.Test;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestDto {
    private String temp;

    public TestDto(Test test) {
        this.temp = test.getTemp();
    }
}
