package com.chainsmoker.marronnier.basket.query.application.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class MemberCockTailBasketDTO {

    private final long memberId;
    private final long cockTailRecipeId;
    private final String cockTailRecipeName;
    private final String cockTailRecipeDescription;
    private final String cockTailRecipeDifficulty;
    private final String getCockTailRecipeImage;
    private final String createdDate;

    public MemberCockTailBasketDTO(long memberId, long cockTailRecipeId, String cockTailRecipeName,String cockTailRecipeDescription, String cockTailRecipeDifficulty, String cockTailRecipeRoot,LocalDateTime createdDate) {
        this.memberId = memberId;
        this.cockTailRecipeId = cockTailRecipeId;
        this.cockTailRecipeName = cockTailRecipeName;
        this.cockTailRecipeDescription = cockTailRecipeDescription;
        this.cockTailRecipeDifficulty = cockTailRecipeDifficulty;
        this.getCockTailRecipeImage = cockTailRecipeRoot;
        this.createdDate = createdDate.format(DateTimeFormatter.ofPattern("YYY년 MM월 dd일 HH시 mm분"));
    }

    @Override
    public String toString() {
        return "MemberCockTailBasketDTO{" +
                " memberId=" + memberId +
                ", cockTailRecipeId=" + cockTailRecipeId +
                ", cockTailRecipeName='" + cockTailRecipeName + '\'' +
                ", cockTailRecipeDescription='" + cockTailRecipeDescription + '\'' +
                ", cockTailRecipeDifficulty='" + cockTailRecipeDifficulty + '\'' +
                ", getCockTailRecipeImage='" + getCockTailRecipeImage + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
