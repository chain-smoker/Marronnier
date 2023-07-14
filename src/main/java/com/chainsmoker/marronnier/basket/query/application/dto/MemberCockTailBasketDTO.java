package com.chainsmoker.marronnier.basket.query.application.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberCockTailBasketDTO {

    private final long memberId;
    private final long cockTailRecipeId;
    private final String cockTailRecipeName;
    private final String cockTailRecipeDescription;
    private final String cockTailRecipeDifficulty;
    private final String getCockTailRecipeImage;
    private final LocalDateTime createdDate;

    public MemberCockTailBasketDTO(long memberId, long cockTailRecipeId, String cockTailRecipeName, String cockTailRecipeDescription, String cockTailRecipeDifficulty, LocalDateTime createdDate) {
        this.memberId = memberId;
        this.cockTailRecipeId = cockTailRecipeId;
        this.cockTailRecipeName = cockTailRecipeName;
        this.cockTailRecipeDescription = cockTailRecipeDescription;
        this.cockTailRecipeDifficulty = cockTailRecipeDifficulty;
        this.getCockTailRecipeImage = null;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "MemberCockTailBasketDTO{" +
                "memberId=" + memberId +
                ", cockTailRecipeId=" + cockTailRecipeId +
                ", cockTailRecipeName='" + cockTailRecipeName + '\'' +
                ", getCockTailRecipeImage='" + getCockTailRecipeImage + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
