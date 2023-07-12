package com.chainsmoker.marronnier.feed.command.application.dto;

import com.chainsmoker.marronnier.feed.command.domain.aggregate.entity.Feed;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateFeedDTO {
    private Long Id;
    private Long memberId;
    private Long cocktailId;
    private String content;

    public UpdateFeedDTO(Feed feed){
        this.Id = feed.getId();
        this.memberId = feed.getMemberId().getId();
        this.cocktailId = feed.getCocktailId().getId();
        this.content=feed.getContent();
    }
}
