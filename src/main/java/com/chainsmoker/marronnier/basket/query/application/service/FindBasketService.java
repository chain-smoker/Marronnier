package com.chainsmoker.marronnier.basket.query.application.service;

import com.chainsmoker.marronnier.basket.query.domain.entity.QueryBasket;
import com.chainsmoker.marronnier.basket.query.domain.service.CocktailRecipeRequest;
import com.chainsmoker.marronnier.basket.query.domain.service.MemberRequest;
import com.chainsmoker.marronnier.basket.query.domain.repository.BasketMapper;
import com.chainsmoker.marronnier.basket.query.application.dto.MemberCockTailBasketDTO;
import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.member.query.application.dto.FindMemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindBasketService {

    private final BasketMapper basketMapper;
    private final MemberRequest memberRequestService;
    private final CocktailRecipeRequest cocktailRecipeRequestService;

    @Autowired
    public FindBasketService(BasketMapper basketMapper, MemberRequest memberRequestService, CocktailRecipeRequest cocktailRecipeRequestService) {
        this.basketMapper = basketMapper;
        this.memberRequestService = memberRequestService;
        this.cocktailRecipeRequestService = cocktailRecipeRequestService;
    }

    public List<MemberCockTailBasketDTO> findByMemberId(long memberId) {
        List<QueryBasket> baskets = basketMapper.findByMemberId(memberId);
        List<MemberCockTailBasketDTO> memberCockTailBasketDTOList = new ArrayList<>();
        for (QueryBasket basket : baskets) {
            FindMemberDTO member = memberRequestService.getMemberById(basket.getMemberId());
            FindCocktailRecipeDTO cocktailRecipe = cocktailRecipeRequestService.getCocktailRecipeById(basket.getCockTailRecipeId());

            MemberCockTailBasketDTO memberCockTailBasketDTO = new MemberCockTailBasketDTO(
                    member.getId(),
                    cocktailRecipe.getId(),
                    cocktailRecipe.getName(),
                    cocktailRecipe.getDescription(),
                    cocktailRecipe.getDifficulty(),
                    basket.getCreatedDate()
            );

            memberCockTailBasketDTOList.add(memberCockTailBasketDTO);
        }
        return memberCockTailBasketDTOList;
    }
}
