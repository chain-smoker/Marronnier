package com.chainsmoker.marronnier.basket.query.domain.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "BASKET_TB")
public class QueryBasket implements Serializable {

    @EmbeddedId
    private BasketCompositeKey basketCompositeKey;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    protected QueryBasket() {}

    public QueryBasket(BasketCompositeKey basketCompositeKey, LocalDateTime createdDate) {
        this.basketCompositeKey = basketCompositeKey;
        this.createdDate = createdDate;
    }
}
