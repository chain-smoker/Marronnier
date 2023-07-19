package com.chainsmoker.marronnier.feed.query.domain.service;

import com.chainsmoker.marronnier.like.command.application.dto.LikeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class LikeService {
    private final CheckLikeService checkLikeService;

    @Autowired
    public LikeService(CheckLikeService checkLikeService) {
        this.checkLikeService = checkLikeService;
    }

    public LikeDTO saveData(long memberId, long feedId) {
        return new LikeDTO(memberId, feedId);
    }

    public boolean checkLike(Map<String, Long> parameter) {
        return checkLikeService.checkLikeByMemberIdAndFeedId(parameter) > 0;
    }

    public int numberOfLikes(long feedId) {
        return checkLikeService.numberOfLike(feedId);
    }

}
