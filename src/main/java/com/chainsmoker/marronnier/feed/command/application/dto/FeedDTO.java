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
        feedDTO.setFeedId(feed.getFeedID());
        feedDTO.setContent(feed.getContent());
        feedDTO.setCocktailId(feed.getCocktailId());
        feedDTO.setMemberId(feed.getMemberId());
    }
}
