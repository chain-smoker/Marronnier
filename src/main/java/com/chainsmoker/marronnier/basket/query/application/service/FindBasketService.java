package com.chainsmoker.marronnier.basket.query.application.service;

import com.chainsmoker.marronnier.basket.query.domain.entity.QueryBasket;
import com.chainsmoker.marronnier.basket.query.domain.repository.FindBasketRepository;
import com.chainsmoker.marronnier.basket.query.domain.service.CocktailRecipeRequest;
import com.chainsmoker.marronnier.basket.query.domain.service.MemberRequest;
import com.chainsmoker.marronnier.basket.query.domain.repository.BasketMapper;
import com.chainsmoker.marronnier.basket.query.application.dto.MemberCockTailBasketDTO;
import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.member.query.application.dto.FindBasketsPaginationDTO;
import com.chainsmoker.marronnier.member.query.application.dto.FindMemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindBasketService {

    private final BasketMapper basketMapper;
    private final MemberRequest memberRequestService;
    private final CocktailRecipeRequest cocktailRecipeRequestService;
    private final FindBasketRepository findBasketRepository;

    @Autowired
    public FindBasketService(BasketMapper basketMapper, MemberRequest memberRequestService, CocktailRecipeRequest cocktailRecipeRequestService, FindBasketRepository findBasketRepository) {
        this.basketMapper = basketMapper;
        this.memberRequestService = memberRequestService;
        this.cocktailRecipeRequestService = cocktailRecipeRequestService;
        this.findBasketRepository = findBasketRepository;
    }

    public List<MemberCockTailBasketDTO> findAllByMemberId(long memberId) {
        List<QueryBasket> baskets = basketMapper.findByMemberId(memberId);

        return mapBasketDTO(baskets);
    }

    public FindBasketsPaginationDTO findAllByMemberIdPagination(long memberId, int page) {
        Pageable sortedByCreatedDateDesc = PageRequest.of(page-1, 5, Sort.by("createdDate").descending());
        Page<QueryBasket> basketsPage = findBasketRepository.findAllByBasketCompositeKey_MemberId(memberId, sortedByCreatedDateDesc);
        int totalPage = basketsPage.getTotalPages();
        return new FindBasketsPaginationDTO(totalPage, mapBasketDTO(basketsPage.getContent()),basketsPage);
    }


    private List<MemberCockTailBasketDTO> mapBasketDTO(List<QueryBasket> baskets) {
        List<MemberCockTailBasketDTO> memberCockTailBasketDTOList = new ArrayList<>();
        for (QueryBasket basket : baskets) {
            FindMemberDTO member = memberRequestService.getMemberById(basket.getBasketCompositeKey().getMember().getId());
            FindCocktailRecipeDTO cocktailRecipe = cocktailRecipeRequestService.getCocktailRecipeById(basket.getBasketCompositeKey().getCockTailRecipe().getId());

            MemberCockTailBasketDTO memberCockTailBasketDTO = new MemberCockTailBasketDTO(
                    member.getId(),
                    cocktailRecipe.getId(),
                    cocktailRecipe.getName(),
                    cocktailRecipe.getDescription(),
                    cocktailRecipe.getDifficulty(),
                    cocktailRecipe.getImg(),
                    basket.getCreatedDate()
            );
            memberCockTailBasketDTOList.add(memberCockTailBasketDTO);
        }
        return memberCockTailBasketDTOList;
    }
}
