package com.chainsmoker.marronnier.basket.command.domain.aggregate.entity;

import com.chainsmoker.marronnier.basket.command.domain.aggregate.vo.CockTailRecipeVO;
import com.chainsmoker.marronnier.basket.command.domain.aggregate.vo.MemberVO;
import com.chainsmoker.marronnier.common.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="BASKET_TB")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Basket extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private MemberVO memberId;

    @Embedded
    private CockTailRecipeVO cockTailRecipeId;

    public Basket(MemberVO memberId, CockTailRecipeVO cockTailRecipeId) {
        this.memberId = memberId;
        this.cockTailRecipeId = cockTailRecipeId;
    }
}
