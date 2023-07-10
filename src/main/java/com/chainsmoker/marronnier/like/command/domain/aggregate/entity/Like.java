package com.chainsmoker.marronnier.like.command.domain.aggregate.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "Like")
@Table(name= "LIKE_TB")
@Getter
@NoArgsConstructor
public class Like implements Serializable {
    @Id
    private Long memberId;
    @Id
    private Long feedId;

    @Builder
    public Like(Long memberId, Long feedId) {
        this.memberId = memberId;
        this.feedId = feedId;
    }
}
