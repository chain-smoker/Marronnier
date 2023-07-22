package com.chainsmoker.marronnier.member.query.application.dto;

import com.chainsmoker.marronnier.basket.query.application.dto.MemberCockTailBasketDTO;
import com.chainsmoker.marronnier.basket.query.domain.entity.QueryBasket;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class FindBasketsPaginationDTO {

    private int totalPage;
    private List<MemberCockTailBasketDTO> baskets;
    private Page<QueryBasket> basketPages;

    public FindBasketsPaginationDTO(int totalPage, List<MemberCockTailBasketDTO> baskets, Page<QueryBasket> basketPages) {
        this.totalPage = totalPage;
        this.baskets = baskets;
        this.basketPages = basketPages;
    }

    @Override
    public String toString() {
        return "FindBasketsPaginationDTO{" +
                "totalPage=" + totalPage +
                ", baskets=" + baskets +
                '}';
    }
}
