package com.chainsmoker.marronnier.feed.query.application.dto;

import com.chainsmoker.marronnier.feed.query.domain.entity.QueryFeed;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@NoArgsConstructor
@ToString
@Getter
public class CheckFeedDTO {
    private Long feedId;
    private Long memberId;
    private Long cocktailId;
    private String content;

    public CheckFeedDTO(QueryFeed feed){
        this.feedId= feed.getFeedId();
        this.memberId = feed.getMemberId();
        this.cocktailId = feed.getCocktailId() ;
        this.content = feed.getContent();
    }
}
