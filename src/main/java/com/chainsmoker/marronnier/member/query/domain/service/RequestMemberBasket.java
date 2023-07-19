package com.chainsmoker.marronnier.member.query.domain.service;

import com.chainsmoker.marronnier.basket.query.application.dto.MemberCockTailBasketDTO;

import java.util.List;

public interface RequestMemberBasket {
    List<MemberCockTailBasketDTO> findBasketByMemberId(long memberId);
}
