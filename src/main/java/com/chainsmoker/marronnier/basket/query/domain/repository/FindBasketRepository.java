package com.chainsmoker.marronnier.basket.query.domain.repository;

import com.chainsmoker.marronnier.basket.query.domain.entity.QueryBasket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FindBasketRepository extends JpaRepository<QueryBasket, Long> {

    Page<QueryBasket> findAllByBasketCompositeKey_MemberId(long memberId, Pageable pageable);
}
