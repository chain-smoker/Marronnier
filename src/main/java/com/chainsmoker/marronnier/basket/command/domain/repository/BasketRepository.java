package com.chainsmoker.marronnier.basket.command.domain.repository;

import com.chainsmoker.marronnier.basket.command.domain.aggregate.entity.Basket;
import com.chainsmoker.marronnier.basket.command.domain.aggregate.entity.BasketCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketRepository  extends JpaRepository<Basket, Long> {

    Basket findByBasketInfo(BasketCompositeKey basketInfo);

}
