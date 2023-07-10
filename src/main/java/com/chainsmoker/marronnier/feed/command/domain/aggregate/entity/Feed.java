package com.chainsmoker.marronnier.feed.command.domain.aggregate.entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Select;

import javax.persistence.*;

@Entity(name="Feed")
@Table(name = "FEED_TB")
@Getter
@NoArgsConstructor
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedID;
    @Column(nullable = false)
    private Long memberId;
    @Column(nullable = false)
    private Long cocktailId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private  String content;

    @Builder
    public Feed(Long feedID, Long memberId, Long cocktailId, String content) {
        this.feedID = feedID;
        this.memberId = memberId;
        this.cocktailId = cocktailId;
        this.content = content;
    }

}
