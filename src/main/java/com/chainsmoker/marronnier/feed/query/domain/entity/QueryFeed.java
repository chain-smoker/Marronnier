package com.chainsmoker.marronnier.feed.query.domain.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "FEED_TB")
@Getter

public class QueryFeed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name="member_id")
    private Long memberId;
    @Column(nullable = false, name = "cocktail_recipe_id")
    private Long cocktailId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private  String content;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
    
}
