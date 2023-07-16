package com.chainsmoker.marronnier.member.command.application.dto;

import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.GenderEnum;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UpdateMemberDTO {
    private String address;
    private String job;
    private LocalDate birthDate;
    private GenderEnum gender;

    public UpdateMemberDTO(String address, String job, LocalDate birthDate, GenderEnum gender) {
        this.address = address;
        this.job = job;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UpdateMemberDTO{" +
                "address='" + address + '\'' +
                ", job='" + job + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                '}';
    }
}
