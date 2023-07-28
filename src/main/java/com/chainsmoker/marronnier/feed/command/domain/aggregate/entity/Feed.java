package com.chainsmoker.marronnier.feed.command.domain.aggregate.entity;
import com.chainsmoker.marronnier.feed.command.application.dto.UpdateFeedDTO;
import com.chainsmoker.marronnier.feed.command.domain.aggregate.VO.CocktailRecipeVO;
import com.chainsmoker.marronnier.feed.command.domain.aggregate.VO.MemberVO;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name="Feed")
@Table(name = "FEED_TB")
@Getter
@NoArgsConstructor
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private MemberVO memberId;
    @Embedded
    private CocktailRecipeVO cocktailId;
    @Column(nullable = false, columnDefinition = "TEXT")
    private  String content;
    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;


    public Feed(MemberVO memberId, CocktailRecipeVO cocktailId, String content) {
        this.memberId = memberId;
        this.cocktailId = cocktailId;
        this.content = content;
        this.createdDate =LocalDateTime.now();
    }

    public Feed(UpdateFeedDTO updateFeedDTO) {
        this.id = updateFeedDTO.getId();
        this.memberId = new MemberVO(updateFeedDTO.getMemberId());
        this.cocktailId = new CocktailRecipeVO( updateFeedDTO.getCocktailId());
        this.content = updateFeedDTO.getContent();
    }
}
