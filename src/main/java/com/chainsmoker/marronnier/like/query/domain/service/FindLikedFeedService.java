package com.chainsmoker.marronnier.like.query.domain.service;

import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;
import com.chainsmoker.marronnier.like.query.domain.repository.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindLikedFeedService {
    private final CheckFeedService checkFeedService;
    private final LikeMapper likeMapper;
    @Autowired
    public FindLikedFeedService(CheckFeedService checkFeedService, LikeMapper likeMapper) {
        this.checkFeedService = checkFeedService;
        this.likeMapper = likeMapper;
    }
    public List<CheckFeedDTO> findLikedFeedsByMemberId(long memberId){
        return checkFeedService.findLikedFeedsById(likeMapper.findLikedFeedByMemberId(memberId));
    }
}
