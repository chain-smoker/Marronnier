package com.chainsmoker.marronnier.basket.command.domain.aggregate.entity;

import com.chainsmoker.marronnier.basket.command.domain.aggregate.vo.CockTailRecipeVO;
import com.chainsmoker.marronnier.basket.command.domain.aggregate.vo.MemberVO;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

@Embeddable
public class BasketCompositeKey implements Serializable {

    @Embedded
    private MemberVO memberId;

    @Embedded
    private CockTailRecipeVO cockTailRecipeId;

    protected BasketCompositeKey() {}

    public BasketCompositeKey(MemberVO memberId, CockTailRecipeVO cockTailRecipeId) {
        this.memberId = memberId;
        this.cockTailRecipeId = cockTailRecipeId;
    }

    public MemberVO getMemberId() {
        return memberId;
    }

    public CockTailRecipeVO getCockTailRecipeId() {
        return cockTailRecipeId;
    }

    @Override
    public String toString() {
        return "BasketCompositeKey{" +
                "memberId=" + memberId +
                ", cockTailRecipeId=" + cockTailRecipeId +
                '}';
    }
}
