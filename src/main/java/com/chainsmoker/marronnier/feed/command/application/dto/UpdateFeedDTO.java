package com.chainsmoker.marronnier.feed.command.application.dto;

import com.chainsmoker.marronnier.feed.command.domain.aggregate.entity.Feed;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UpdateFeedDTO {
    private Long Id;
    private Long memberId;
    private Long cocktailId;
    private String content;
    private LocalDateTime createdDate;

    public UpdateFeedDTO(Feed feed){
        this.Id = feed.getId();
        this.memberId = feed.getMemberId().getId();
        this.cocktailId = feed.getCocktailId().getId();
        this.content=feed.getContent();
        this.createdDate=feed.getCreatedDate();
    }
}
