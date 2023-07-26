package com.chainsmoker.marronnier.like.query.domain.service;

import com.chainsmoker.marronnier.like.query.domain.repository.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FindLikeService {
    private final LikeMapper likeMapper;
    @Autowired
    public FindLikeService(LikeMapper likeMapper){
        this.likeMapper = likeMapper;
    }
    public int findLikeByMemberIdAndFeedId(Map<String,Long> parameter){
        Integer check = likeMapper.findLikeByMemberIdAndFeedId(parameter);
        return check;
    }
    public int findAllLike(long feedId){
        return likeMapper.findNumberOfLike(feedId);
    }

    public List<Long> findLikedFeedByMemberId(long memberId){
        List<Long> list = likeMapper.findLikedFeedByMemberId(memberId);
        return list;
    }
}
