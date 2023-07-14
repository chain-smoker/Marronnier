package com.chainsmoker.marronnier.apply.query.application.dto;

import com.chainsmoker.marronnier.apply.command.domain.aggregate.entity.EnumType.CategoryEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class QueryApplyDTO {
    private long id;                    // 요청 번호
    private String title;               // 제목
    private String content;             // 본문
    private CategoryEnum category;      // 카테고리(칵테일 조주법, 재료)
    private boolean isApproval;         // 승인 여부
    private LocalDateTime createdDate;  // 작성 날짜
    private LocalDateTime modifiedDate; // 수정 날짜
    private long requesterId;           // 회원 번호

}
