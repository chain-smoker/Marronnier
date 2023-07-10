package com.chainsmoker.marronnier.like.command.domain.aggregate.entiry;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Like")
@Table(name= "tbl_like")
@Getter
@NoArgsConstructor
public class Like {
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
