package com.chainsmoker.marronnier.like.command.domain.aggregate.entity;
import com.chainsmoker.marronnier.like.command.domain.aggregate.vo.LikeVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "Like")
@Table(name= "LIKE_TB")
@Getter
@NoArgsConstructor
public class Like implements Serializable {
    @EmbeddedId
    private LikeVO like;
    public Like(LikeVO like) {
        this.like=like;
    }
    public Like(long memberId, long feedid){
        this.like = new LikeVO(feedid,memberId);
    }
}
