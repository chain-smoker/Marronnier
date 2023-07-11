package com.chainsmoker.marronnier.basket.command.application.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DeleteBasketDTO {
    private long basketId;
    private long cockTailRecipeId;
}
