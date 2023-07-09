package com.chainsmoker.marronnier.member.query.domain.entity.vo;

import java.text.ParseException;
import java.time.LocalDate;

public class AgeRangeVO {

    private int ageRange;

    public AgeRangeVO() {}
    public AgeRangeVO(String ageStr) throws ParseException {
        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.parse(ageStr);
        int yearDiff = today.getYear() - birthDate.getYear() - 1;
        if(today.getMonth().getValue() >= birthDate.getMonth().getValue() && today.getDayOfMonth() >= birthDate.getDayOfMonth()) {
            yearDiff++;
        }
        this.ageRange = ((int) yearDiff/10) * 10;
    }

    public int getAgeRange() {
        return ageRange;
    }
}
