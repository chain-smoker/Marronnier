package com.chainsmoker.marronnier.basket.command.application.service;

import com.chainsmoker.marronnier.basket.command.application.dto.CreateBasketDTO;
import com.chainsmoker.marronnier.basket.command.domain.aggregate.entity.Basket;
import com.chainsmoker.marronnier.basket.command.domain.aggregate.entity.BasketCompositeKey;
import com.chainsmoker.marronnier.basket.command.domain.aggregate.vo.CockTailRecipeVO;
import com.chainsmoker.marronnier.basket.command.domain.aggregate.vo.MemberVO;
import com.chainsmoker.marronnier.basket.command.domain.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistBasketService {

    private final BasketRepository basketRepository;

    @Autowired
    public RegistBasketService (BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }


    public void create(CreateBasketDTO createBasketDTO) {

        long memberId = createBasketDTO.getMemberId();
        long cockTailRecipeId = createBasketDTO.getCockTailRecipeId();

        MemberVO memberVO = new MemberVO(memberId);
        CockTailRecipeVO cockTailRecipeVO = new CockTailRecipeVO(cockTailRecipeId);

        BasketCompositeKey basketInfo = new BasketCompositeKey(memberVO, cockTailRecipeVO);

        Basket basket = new Basket(basketInfo);
        Basket result = basketRepository.save(basket);
    }
}
