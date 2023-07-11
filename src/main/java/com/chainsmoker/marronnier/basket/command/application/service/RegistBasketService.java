package com.chainsmoker.marronnier.basket.command.application.service;

import com.chainsmoker.marronnier.basket.command.application.dto.CreateBasketDTO;
import com.chainsmoker.marronnier.basket.command.domain.aggregate.entity.Basket;
import com.chainsmoker.marronnier.basket.command.domain.aggregate.vo.CockTailRecipeVO;
import com.chainsmoker.marronnier.basket.command.domain.aggregate.vo.MemberVO;
import com.chainsmoker.marronnier.basket.command.infra.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistBasketService {

    private final BasketRepository basketRepository;

    @Autowired
    public RegistBasketService (BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public long create(CreateBasketDTO createBasketDTO) {

        long memberId = createBasketDTO.getMemberId();
        long cockTailRecipeId = createBasketDTO.getCockTailRecipeId();

        MemberVO memberVO = MemberVO
                .builder()
                .id(memberId)
                .build();
        CockTailRecipeVO cockTailRecipeVO = CockTailRecipeVO
                .builder()
                .id(cockTailRecipeId)
                .build();

        Basket basket = Basket.builder()
                .memberId(memberVO)
                .cockTailRecipeId(cockTailRecipeVO)
                .build();
        Basket result = basketRepository.save(basket);
        return result.getId();
    }
}
