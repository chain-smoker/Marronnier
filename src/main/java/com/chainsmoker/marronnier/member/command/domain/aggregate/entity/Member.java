package com.chainsmoker.marronnier.member.command.domain.aggregate.entity;

import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.GenderEnum;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.PlatformEnum;
import com.chainsmoker.marronnier.member.command.domain.aggregate.vo.AgeVO;

public class Member {

    private int memberID;
    private String name;
    private String UID;
    private String address;
    private GenderEnum gender;
    private AgeVO ageRange;
    private String refreshToken;
    private PlatformEnum platform;

    public Member(int memberID, String name, String UID, String address, GenderEnum gender, AgeVO ageRange, String refreshToken, PlatformEnum platform) {
        this.memberID = memberID;
        this.name = name;
        this.UID = UID;
        this.address = address;
        this.gender = gender;
        this.ageRange = ageRange;
        this.refreshToken = refreshToken;
        this.platform = platform;
    }

    public int getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public String getUID() {
        return UID;
    }

    public AgeVO getAgeRange() {
        return ageRange;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
