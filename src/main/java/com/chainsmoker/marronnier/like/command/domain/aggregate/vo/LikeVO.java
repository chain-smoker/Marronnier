package com.chainsmoker.marronnier.like.command.domain.aggregate.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class LikeVO implements Serializable {

    @Column(nullable = false, name = "feed_id")
    long feedId;
    @Column(nullable = false, name = "member_id")
    long memberId;

    public LikeVO(long feedId, long memberId) {
        this.feedId = feedId;
        this.memberId = memberId;
    }
}