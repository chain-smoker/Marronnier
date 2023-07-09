package com.chainsmoker.marronnier.member.command.domain.aggregate.entity;

import com.chainsmoker.marronnier.common.entity.BaseTimeEntity;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.GenderEnum;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.PlatformEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

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

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlatformEnum platform;

    @Builder
    public Member(String name, Long UID, String address, GenderEnum gender, LocalDate birthDate, PlatformEnum platform) {
        this.name = name;
        this.UID = UID;
        this.address = address;
        this.gender = gender;
        this.birthDate = birthDate;
        this.platform = platform;
    }
}
