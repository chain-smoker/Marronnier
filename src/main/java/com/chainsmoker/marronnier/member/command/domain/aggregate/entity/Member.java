package com.chainsmoker.marronnier.member.command.domain.aggregate.entity;

import com.chainsmoker.marronnier.common.entity.BaseTimeEntity;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.GenderEnum;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.PlatformEnum;

import java.time.LocalDate;

import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.Role;
import com.chainsmoker.marronnier.member.command.domain.aggregate.vo.BirthDateVO;
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

    @Column(length = 100, name = "profile_image")
    private String profileImage;

    private String job;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Embedded
    private BirthDateVO birthDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlatformEnum platform;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


    public Member(String name, Long uid, String address, GenderEnum gender, BirthDateVO birthDate, PlatformEnum platform, String job) {
        this.name = name;
        this.UID = uid;
        this.address = address;
        this.gender = gender;
        this.birthDate = birthDate;
        this.platform = platform;
        this.role = Role.MEMBER;
        this.job = job;
    }

    public Member(String name, long uid, PlatformEnum platform, Role role, String profileImage) {
        this.name = name;
        this.UID = uid;
        this.platform = platform;
        this.role = role;
        this.profileImage = profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
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

    public void setBirthDate(BirthDateVO birthDate) {
        this.birthDate = birthDate;
    }

    public void setRole(Role role) {this.role = role;}

    public void setJob(String job) {
        this.job = job;
    }

}
