package com.chainsmoker.marronnier.like.query.domain.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LikeMapper {
    int findNumberOfLike(long feedId);
    int findLikeByMemberIdAndFeedId(Map<String,Long> parameter);
    List<Long> findLikedFeedByMemberId(Long memberId);
}
