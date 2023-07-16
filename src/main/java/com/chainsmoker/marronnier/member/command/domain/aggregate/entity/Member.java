package com.chainsmoker.marronnier.member.command.domain.aggregate.entity;

import com.chainsmoker.marronnier.common.entity.BaseTimeEntity;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.GenderEnum;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.PlatformEnum;

import java.time.LocalDate;

import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="MEMBER_TB")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String name;

    @Column(nullable = false, name = "uid")
    private Long UID;

    private String address;

    private String job;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlatformEnum platform;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


    public Member(String name, Long uid, String address, GenderEnum gender, LocalDate birthDate, PlatformEnum platform, String job) {
        this.name = name;
        this.UID = uid;
        this.address = address;
        this.gender = gender;
        this.birthDate = birthDate;
        this.platform = platform;
        this.role = Role.MEMBER;
        this.job = job;
    }

    public Member(String name, long uid, PlatformEnum platform, Role role) {
        this.name = name;
        this.UID = uid;
        this.platform = platform;
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setRole(Role role) {this.role = role;}

    public void setJob(String job) {
        this.job = job;
    }

}
