package com.chainsmoker.marronnier.member.command.application.dto;

import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.GenderEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateMemberDTO {
    private String address;
    private String job;
    private LocalDate birthDate;
    private GenderEnum gender;
    private String profileImage;

    public UpdateMemberDTO() {}

    public UpdateMemberDTO(String address, String job, LocalDate birthDate, GenderEnum gender, String profileImage) {
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
