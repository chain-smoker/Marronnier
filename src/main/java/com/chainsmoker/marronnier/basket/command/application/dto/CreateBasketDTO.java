package com.chainsmoker.marronnier.basket.command.application.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateBasketDTO {
    private long memberId;
    private long cockTailRecipeId;
}
