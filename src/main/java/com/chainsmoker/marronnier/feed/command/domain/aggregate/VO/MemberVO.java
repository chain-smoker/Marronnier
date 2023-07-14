package com.chainsmoker.marronnier.feed.command.domain.aggregate.VO;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberVO {
    @Column(nullable = false, name ="member_id")
    private long id;

    @Builder
    public MemberVO(long memberId){
        this.id = memberId;
    }
}
