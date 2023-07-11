package com.chainsmoker.marronnier.member.query.application.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MemberCockTailBasketDTO {

    private long memberId;
    private long cockTailRecipeId;
    private String cockTailRecipeName;
    private String getCockTailRecipeImage;
    private LocalDateTime createdDate;
}
