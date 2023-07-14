package com.chainsmoker.marronnier.like.command.domain.repository;

import com.chainsmoker.marronnier.like.command.domain.aggregate.entity.Like;
import com.chainsmoker.marronnier.like.command.domain.aggregate.vo.LikeVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, LikeVO> {
    @Modifying
    @Query(value = "delete from like_tb WHERE member_id = ?1 AND feed_id = ?2",nativeQuery = true)
    int deleteByLike(long memberId, long feedId);
}
