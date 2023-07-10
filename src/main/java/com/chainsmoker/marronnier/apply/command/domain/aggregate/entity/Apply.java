package com.chainsmoker.marronnier.apply.command.domain.aggregate.entity;

import com.chainsmoker.marronnier.apply.command.domain.aggregate.entity.EnumType.CategoryEnum;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Apply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;                     // 요청 번호

    @Column(length = 50)
    private String title;               // 제목

    @Column(columnDefinition = "TEXT")
    private String content;             // 본문

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;      // 카테고리(칵테일 조주법, 재료)

    private boolean isApproval;         // 승인 여부

    @CreatedDate
    private LocalDateTime createDate;   // 작성 일자

    @Column(nullable = false)
    private Long rquesterId;            // 회원 번호

    @Builder
    public Apply(int no, String title, String content, CategoryEnum category, boolean isApproval, LocalDateTime createDate, Long rquesterId) {
        this.no = no;
        this.title = title;
        this.content = content;
        this.category = category;
        this.isApproval = isApproval;
        this.createDate = createDate;
        this.rquesterId = rquesterId;
    }
}
