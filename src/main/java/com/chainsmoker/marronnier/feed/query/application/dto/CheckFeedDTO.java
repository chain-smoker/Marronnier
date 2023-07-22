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
    private Long Id;
    private Long memberId;
    private String writer;
    private Long cocktailId;
    private String content;
    private int like;

    public CheckFeedDTO(QueryFeed feed){
        this.Id= feed.getId();
        this.memberId = feed.getMemberId();
        this.cocktailId = feed.getCocktailId() ;
        this.content = feed.getContent();
    }
    public CheckFeedDTO(QueryFeed feed,int like, String writer){
        this.Id= feed.getId();
        this.memberId = feed.getMemberId();
        this.cocktailId = feed.getCocktailId() ;
        this.content = feed.getContent();
        this.like=like;
        this.writer=writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
