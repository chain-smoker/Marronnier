package com.chainsmoker.marronnier.basket.command.domain.aggregate.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Getter
@Embeddable
public class MemberVO {

    @Column(nullable = false, name = "member_id")
    private long id;

    public MemberVO(long id) {
        this.id = id;
    }

    protected MemberVO() {}
}
