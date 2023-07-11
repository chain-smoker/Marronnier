package com.chainsmoker.marronnier.feed.command.application.service;

import com.chainsmoker.marronnier.feed.command.application.dto.CreateFeedDTO;
import com.chainsmoker.marronnier.feed.command.domain.aggregate.VO.CocktailRecipeVO;
import com.chainsmoker.marronnier.feed.command.domain.aggregate.VO.MemberVO;
import com.chainsmoker.marronnier.feed.command.domain.aggregate.entity.Feed;
import com.chainsmoker.marronnier.feed.command.domain.repository.FeedReposiroty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedInsertService {
    private final FeedReposiroty feedReposiroty;

    public void saveFeed(CreateFeedDTO feedWriteDTO){
        MemberVO memberId = MemberVO.builder()
                        .memberId(feedWriteDTO.getMemberId()).build();
        CocktailRecipeVO cocktailRecipeVO = CocktailRecipeVO.builder()
                        .cocktailId(feedWriteDTO.getCocktailId()).build();

//        CreateFeedDTO feedDTO = new (123,123,123,123,123,123,123);
//        -> to entity 로 바꿔서 그냥 save떄리면 끝..

        feedReposiroty.save(Feed.builder()
                .content( feedWriteDTO.getContent())
                .memberId(memberId)
                .cocktailId(cocktailRecipeVO)
                .build()
        );
    }
}
