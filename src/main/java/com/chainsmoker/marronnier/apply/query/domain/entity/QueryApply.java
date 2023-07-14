package com.chainsmoker.marronnier.apply.query.domain.entity;

import com.chainsmoker.marronnier.apply.command.domain.aggregate.entity.EnumType.CategoryEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "APPLY_TB")
public class QueryApply {

    @Id
    @Column(name = "id")
    private long id;                     // 요청 번호

    @Column(name = "title", length = 50)
    private String title;               // 제목

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;             // 본문

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;      // 카테고리(칵테일 조주법, 재료)

    @Column(name = "is_approval")
    private boolean isApproval;         // 승인 여부

    @Column(name = "created_date")
    private LocalDateTime createdDate;  // 작성 날짜

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate; // 수정 날짜

    @Column(name ="requester_id", nullable = false)
    private long requesterId;            // 회원 번호

}
