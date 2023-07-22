package com.chainsmoker.marronnier.basket.query.domain.entity.vo;

import lombok.Getter;

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
