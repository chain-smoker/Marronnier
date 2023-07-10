package com.chainsmoker.marronnier.feed.query.domain.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "FEED_TB")
@Getter

public class QueryFeed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedID;
    @Column(nullable = false)
    private Long memberId;
    @Column(nullable = false)
    private Long cocktailId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private  String content;
    
}
