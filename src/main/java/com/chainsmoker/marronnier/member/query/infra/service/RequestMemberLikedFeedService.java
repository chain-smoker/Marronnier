package com.chainsmoker.marronnier.member.query.infra.service;

import com.chainsmoker.marronnier.common.annotation.InfraService;
import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;
import com.chainsmoker.marronnier.feed.query.domain.entity.QueryFeed;
import com.chainsmoker.marronnier.like.query.domain.service.FindLikedFeedService;
import com.chainsmoker.marronnier.member.query.domain.service.RequestMemberLikedFeed;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@InfraService
public class RequestMemberLikedFeedService implements RequestMemberLikedFeed {

    private final FindLikedFeedService findLikedFeedService;

    @Autowired
    public RequestMemberLikedFeedService(FindLikedFeedService findLikedFeedService) {
        this.findLikedFeedService = findLikedFeedService;
    }

    @Override
    public List<CheckFeedDTO> findLikedFeed(long memberId) {
        return findLikedFeedService.findLikedFeedsByMemberId(memberId);
    }
}
