package com.chainsmoker.marronnier.basket.query.domain.entity;

import com.chainsmoker.marronnier.common.entity.BaseTimeEntity;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "BASKET_TB")
@Getter
public class QueryBasket extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "member_id")
    private long memberId;

    @Column(nullable = false, name = "cocktail_recipe_id")
    private long cockTailRecipeId;
}
