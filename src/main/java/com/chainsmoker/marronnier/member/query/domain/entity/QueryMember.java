package com.chainsmoker.marronnier.member.query.domain.entity;

import com.chainsmoker.marronnier.common.entity.BaseTimeEntity;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.GenderEnum;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.PlatformEnum;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MEMBER_TB")
@Getter
public class QueryMember extends BaseTimeEntity {
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

}