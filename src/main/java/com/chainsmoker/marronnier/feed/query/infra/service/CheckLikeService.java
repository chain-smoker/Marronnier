package com.chainsmoker.marronnier.feed.query.infra.service;

import com.chainsmoker.marronnier.like.query.domain.service.FindLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CheckLikeService implements com.chainsmoker.marronnier.feed.query.domain.service.CheckLikeService {
    private final FindLikeService findLikeService;
    @Autowired
    public CheckLikeService(FindLikeService findLikeService){
        this.findLikeService = findLikeService;
    }
    public int checkLikeByMemberIdAndFeedId(Map<String, Long> parameter) {
        int result = findLikeService.findLikeByMemberIdAndFeedId(parameter);
        return result;
    }
    public int numberOfLike(long feedId){
        return findLikeService.findAllLike(feedId);
    }
}
