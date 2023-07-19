package com.chainsmoker.marronnier.apply.command.domain.aggregate.entity;

import com.chainsmoker.marronnier.apply.command.domain.aggregate.entity.EnumType.CategoryEnum;
import com.chainsmoker.marronnier.common.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "APPLY_TB")
public class Apply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name ="requester_id", nullable = false)
    private long requesterId;            // 회원 번호

    public Apply(String title, String content, CategoryEnum category, boolean isApproval, long requesterId) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.isApproval = isApproval;
        this.requesterId = requesterId;
    }
}
