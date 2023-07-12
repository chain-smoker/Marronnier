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
public class CocktailRecipeVO {
    @Column(nullable = false, name ="cocktailId")
    private long id;

    @Builder
    public CocktailRecipeVO(long cocktailId){
        this.id=cocktailId;
    }
}
