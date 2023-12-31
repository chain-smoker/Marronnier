package com.chainsmoker.marronnier.feed.command.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CreateFeedDTO {
    private Long memberId;
    private Long cocktailId;
    private String content;
}
