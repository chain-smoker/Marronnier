package com.chainsmoker.marronnier.basket.command.application.service;

import com.chainsmoker.marronnier.basket.command.application.dto.DeleteBasketDTO;
import com.chainsmoker.marronnier.basket.command.domain.aggregate.entity.Basket;
import com.chainsmoker.marronnier.basket.command.domain.aggregate.entity.BasketCompositeKey;
import com.chainsmoker.marronnier.basket.command.domain.aggregate.vo.CockTailRecipeVO;
import com.chainsmoker.marronnier.basket.command.domain.aggregate.vo.MemberVO;
import com.chainsmoker.marronnier.basket.command.domain.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteBasketService {

    private final BasketRepository basketRepository;

    @Autowired
    public DeleteBasketService (BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public void delete(DeleteBasketDTO deleteBasketDTO) {

        MemberVO member = new MemberVO(deleteBasketDTO.getMemberId());
        CockTailRecipeVO cockTailRecipe = new CockTailRecipeVO(deleteBasketDTO.getCockTailRecipeId());

        BasketCompositeKey basketInfo = new BasketCompositeKey(member, cockTailRecipe);
        Basket findBasket = basketRepository.findByBasketInfo(basketInfo);

        basketRepository.delete(findBasket);
    }
}
