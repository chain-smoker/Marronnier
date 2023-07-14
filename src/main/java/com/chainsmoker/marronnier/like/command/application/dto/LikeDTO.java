package com.chainsmoker.marronnier.like.command.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class LikeDTO {
    private long memberId;
    private long feedId;

    public LikeDTO(long memberId, long feedId) {
        this.memberId = memberId;
        this.feedId = feedId;
    }
}
