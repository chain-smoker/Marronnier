package com.chainsmoker.marronnier.basket.query.domain.repository;


import com.chainsmoker.marronnier.basket.query.domain.entity.QueryBasket;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BasketMapper {

    List<QueryBasket> findByMemberId(long memberId);
}
