package com.chainsmoker.marronnier.basket.command.domain.aggregate.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
