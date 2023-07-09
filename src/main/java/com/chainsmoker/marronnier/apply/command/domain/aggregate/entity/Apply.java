package com.chainsmoker.marronnier.apply.command.domain.aggregate.entity;

import com.chainsmoker.marronnier.apply.command.domain.aggregate.entity.EnumType.CategoryEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
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

//    @ManyToOne 회원번호? 작성자 이름? (실제 데이터베이스에서는 ForeignKey 관계가 생성)
//    private Member member;

}
