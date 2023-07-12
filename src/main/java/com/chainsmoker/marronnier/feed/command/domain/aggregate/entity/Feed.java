package com.chainsmoker.marronnier.feed.command.domain.aggregate.entity;
import com.chainsmoker.marronnier.feed.command.domain.aggregate.VO.CocktailRecipeVO;
import com.chainsmoker.marronnier.feed.command.domain.aggregate.VO.MemberVO;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.Member;
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
    private Long Id;
    @Embedded
    private MemberVO memberId;
    @Embedded
    private CocktailRecipeVO cocktailId;
    @Column(nullable = false, columnDefinition = "TEXT")
    private  String content;

    @Builder
    public Feed(MemberVO memberId, CocktailRecipeVO cocktailId, String content) {
        this.memberId = memberId;
        this.cocktailId = cocktailId;
        this.content = content;
    }

}
