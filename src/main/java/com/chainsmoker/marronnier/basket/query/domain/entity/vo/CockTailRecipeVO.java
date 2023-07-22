package com.chainsmoker.marronnier.basket.query.domain.entity.vo;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
public class CockTailRecipeVO {
    @Column(nullable = false, name = "cocktail_recipe_id")
    private long id;

    public CockTailRecipeVO(long id) {
        this.id = id;
    }

    protected CockTailRecipeVO() {}
}
