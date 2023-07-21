package com.chainsmoker.marronnier.basket.query.domain.entity;

import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
public class QueryBasket implements Serializable {

    private long memberId;

    private long cockTailRecipeId;

    private LocalDateTime createdDate;

}
