package com.chainsmoker.marronnier.apply.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@ToString
public class CreateApplyDTO {
    private String title;               // 제목
    private String content;             // 본문
    private String category;            // 카테고리(칵테일 조주법, 재료)
    private boolean isApproval;         // 승인 여부
    private long requesterId;           // 회원 번호
}
