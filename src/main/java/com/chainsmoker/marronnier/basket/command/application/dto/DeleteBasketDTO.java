package com.chainsmoker.marronnier.basket.command.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteBasketDTO {
    private long basketId;
    private long cockTailRecipeId;

    public DeleteBasketDTO(long basketId, long cockTailRecipeId) {
        this.basketId = basketId;
        this.cockTailRecipeId = cockTailRecipeId;
    }
}
