package com.chainsmoker.marronnier.member.command.application.dto;

import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.GenderEnum;
import com.chainsmoker.marronnier.member.command.domain.aggregate.vo.BirthDateVO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateMemberDTO {
    private String address;
    private String job;
    private BirthDateVO birthDate;
    private GenderEnum gender;
    private String profileImage;

    public UpdateMemberDTO() {}

    public UpdateMemberDTO(String address, String job, BirthDateVO birthDate, GenderEnum gender, String profileImage) {
        this.address = address;
        this.job = job;
        this.birthDate = birthDate;
        this.gender = gender;
        this.profileImage = profileImage;
    }

    public UpdateMemberDTO(String profileImage) {
        this.profileImage = profileImage;
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
