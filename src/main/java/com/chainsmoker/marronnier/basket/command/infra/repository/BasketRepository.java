package com.chainsmoker.marronnier.basket.command.infra.repository;

import com.chainsmoker.marronnier.basket.command.domain.aggregate.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository  extends JpaRepository<Basket, Long> {
}
