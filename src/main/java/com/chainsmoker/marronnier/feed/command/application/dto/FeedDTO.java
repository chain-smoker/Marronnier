package com.chainsmoker.marronnier.feed.command.application.dto;

import com.chainsmoker.marronnier.feed.command.domain.aggregate.entity.Feed;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Setter
public class FeedDTO {
    private Long feedId;
    private Long memberId;
    private Long cocktailId;
    private String content;

    private static FeedDTO toFeedDTO(Feed feed){
        FeedDTO feedDTO = new FeedDTO();
        feedDTO.setFeedId(feed.getFeedId());
        feedDTO.setContent(feed.getContent());
        feedDTO.setCocktailId(feed.getCocktailId().getId());
        feedDTO.setMemberId(feed.getMemberId().getId());

        return feedDTO;
    }
    public FeedDTO(Feed feed){
        this.feedId = feed.getFeedId();
        this.memberId = feed.getMemberId().getId();
        this.cocktailId = feed.getCocktailId().getId();
        this.content=feed.getContent();
    }
}
