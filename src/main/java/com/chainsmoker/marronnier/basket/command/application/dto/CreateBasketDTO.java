package com.chainsmoker.marronnier.basket.command.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBasketDTO {
    private long memberId;
    private long cockTailRecipeId;

    public CreateBasketDTO(long memberId, long cockTailRecipeId) {
        this.memberId = memberId;
        this.cockTailRecipeId = cockTailRecipeId;
    }
}
