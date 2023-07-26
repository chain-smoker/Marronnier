package com.chainsmoker.marronnier.member.command.domain.aggregate.vo;

import com.chainsmoker.marronnier.member.command.domain.exception.BirthDateAfterException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Embeddable
public class BirthDateVO {

    @Column(name = "birth_date")
    private LocalDate birthDate;

    protected BirthDateVO() {
    }

    public BirthDateVO(LocalDate birthDate) {
        LocalDate now = LocalDate.now();
        if (birthDate.isBefore(now)) {
            this.birthDate = birthDate;
        } else {
            throw new BirthDateAfterException("생년월일은 오늘 이전이어야 합니다.");
        }
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getFormattedBirthDate() {
        return birthDate.format(DateTimeFormatter.ofPattern("YYYY년 MM월 dd일 HH시 mm분"));
    }
}
