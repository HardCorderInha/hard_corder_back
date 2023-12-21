package inha.hardcorder.domain;

import inha.hardcorder.dto.TestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Long id;

    private String temp;

    public Test(TestDto test) {
        this.temp = test.getTemp();
    }
}
