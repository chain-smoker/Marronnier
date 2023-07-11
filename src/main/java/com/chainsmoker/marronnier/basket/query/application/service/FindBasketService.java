package com.chainsmoker.marronnier.basket.query.application.service;

import com.chainsmoker.marronnier.basket.query.domain.entity.QueryBasket;
import com.chainsmoker.marronnier.basket.query.domain.service.MemberRequestService;
import com.chainsmoker.marronnier.basket.query.infra.repository.BasketMapper;
import com.chainsmoker.marronnier.member.query.application.dto.MemberCockTailBasketDTO;
import com.chainsmoker.marronnier.member.query.domain.entity.QueryMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindBasketService {

    private final BasketMapper basketMapper;
    private final MemberRequestService memberRequestService;

    @Autowired
    public FindBasketService(BasketMapper basketMapper, MemberRequestService memberRequestService) {
        this.basketMapper = basketMapper;
        this.memberRequestService = memberRequestService;
    }

    public List<MemberCockTailBasketDTO> findByMemberId(long memberId) {
        List<QueryBasket> baskets = basketMapper.findByMemberId(memberId);
        List<MemberCockTailBasketDTO> memberCockTailBasketDTOList = new ArrayList<>();
        for (QueryBasket basket : baskets) {
            QueryMember member = memberRequestService.getMemberById(basket.getMemberId());
            MemberCockTailBasketDTO memberCockTailBasketDTO = MemberCockTailBasketDTO
                    .builder()
                    .cockTailRecipeId(basket.getCockTailRecipeId())
                    .cockTailRecipeName(member.getName())
                    .memberId(member.getId())
                    .createdDate(basket.getCreatedDate())
                    .build();
            memberCockTailBasketDTOList.add(memberCockTailBasketDTO);
        }
        return memberCockTailBasketDTOList;
    }
}
