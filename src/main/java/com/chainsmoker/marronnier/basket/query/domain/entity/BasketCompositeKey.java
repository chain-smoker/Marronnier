package com.chainsmoker.marronnier.basket.query.domain.entity;

import com.chainsmoker.marronnier.basket.query.domain.entity.vo.MemberVO;
import com.chainsmoker.marronnier.basket.query.domain.entity.vo.CockTailRecipeVO;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

@Embeddable
public class BasketCompositeKey implements Serializable {

    @Embedded
    private MemberVO member;

    @Embedded
    private CockTailRecipeVO cockTailRecipe;

    protected BasketCompositeKey() {}

    public BasketCompositeKey(MemberVO member, CockTailRecipeVO cockTailRecipe) {
        this.member = member;
        this.cockTailRecipe = cockTailRecipe;
    }

    public MemberVO getMember() {
        return member;
    }

    public CockTailRecipeVO getCockTailRecipe() {
        return cockTailRecipe;
    }

    @Override
    public String toString() {
        return "BasketCompositeKey{" +
                "memberId=" + member +
                ", cockTailRecipeId=" + cockTailRecipe +
                '}';
    }
}
