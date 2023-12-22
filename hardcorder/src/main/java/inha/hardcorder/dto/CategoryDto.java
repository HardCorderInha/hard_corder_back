package inha.hardcorder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private String type; // 알고, 자구, 디비 ,,
    private String level; // 상 중 하
}
