package com.chainsmoker.marronnier.member.query.infra.service;

import com.chainsmoker.marronnier.basket.query.application.dto.MemberCockTailBasketDTO;
import com.chainsmoker.marronnier.basket.query.application.service.FindBasketService;
import com.chainsmoker.marronnier.common.annotation.InfraService;
import com.chainsmoker.marronnier.member.query.domain.service.RequestMemberBasket;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@InfraService
public class RequestMemberBasketService implements RequestMemberBasket {

    private final FindBasketService findBasketService;

    @Autowired
    public RequestMemberBasketService(FindBasketService findBasketService) {
        this.findBasketService = findBasketService;

    }

    @Override
    public List<MemberCockTailBasketDTO> findBasketByMemberId(long memberId) {
        return findBasketService.findAllByMemberId(memberId);
    }
}
