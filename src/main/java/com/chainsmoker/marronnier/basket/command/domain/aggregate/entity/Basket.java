package com.chainsmoker.marronnier.basket.command.domain.aggregate.entity;

import com.chainsmoker.marronnier.common.entity.BaseTimeEntity;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="BASKET_TB")
@Getter
public class Basket {

    @EmbeddedId
    private BasketCompositeKey basketInfo;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public Basket(BasketCompositeKey basketInfo) {
        this.basketInfo = basketInfo;
        this.createdDate = LocalDateTime.now();
    }

    protected Basket() {};

    public BasketCompositeKey getBasketInfo() {
        return basketInfo;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basketInfo=" + basketInfo +
                '}';
    }
}
