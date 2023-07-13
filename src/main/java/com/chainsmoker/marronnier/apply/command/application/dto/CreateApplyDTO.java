package com.chainsmoker.marronnier.apply.command.application.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CreateApplyDTO {
    private String title;               // 제목
    private String content;             // 본문
    private String category;            // 카테고리(칵테일 조주법, 재료)
    private boolean isApproval;         // 승인 여부
    private long requesterId;           // 회원 번호

    public CreateApplyDTO(String title, String content, String category, boolean isApproval, long requesterId) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.isApproval = isApproval;
        this.requesterId = requesterId;
    }
}
