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
    private String profileImage;
    private String cocktailName;

    public CheckFeedDTO(QueryFeed feed){
        this.Id= feed.getId();
        this.memberId = feed.getMemberId();
        this.cocktailId = feed.getCocktailId() ;
        this.content = feed.getContent();
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public void setCocktailId(Long cocktailId) {
        this.cocktailId = cocktailId;
    }
}
