package com.chainsmoker.marronnier.feed.command.application.service;

import com.chainsmoker.marronnier.feed.command.application.dto.CreateFeedDTO;
import com.chainsmoker.marronnier.feed.command.domain.aggregate.VO.CocktailRecipeVO;
import com.chainsmoker.marronnier.feed.command.domain.aggregate.VO.MemberVO;
import com.chainsmoker.marronnier.feed.command.domain.aggregate.entity.Feed;
import com.chainsmoker.marronnier.feed.command.domain.repository.FeedReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedInsertService {
    private final FeedReposiroty feedReposiroty;

    @Autowired
    public FeedInsertService(FeedReposiroty feedReposiroty) {
        this.feedReposiroty = feedReposiroty;
    }

    public long saveFeed(CreateFeedDTO feedWriteDTO) {
        MemberVO memberId = MemberVO.builder()
                .memberId(feedWriteDTO.getMemberId()).build();
        CocktailRecipeVO cocktailRecipeVO = CocktailRecipeVO.builder()
                .cocktailId(feedWriteDTO.getCocktailId()).build();

        return feedReposiroty.save(Feed.builder()
                .content(feedWriteDTO.getContent())
                .memberId(memberId)
                .cocktailId(cocktailRecipeVO)
                .build()
        ).getId();
    }
}
