package com.chainsmoker.marronnier.member.query.infra.service;

import com.chainsmoker.marronnier.common.annotation.InfraService;
import com.chainsmoker.marronnier.feed.query.application.service.FindFeedService;
import com.chainsmoker.marronnier.feed.query.domain.entity.QueryFeed;
import com.chainsmoker.marronnier.like.query.domain.service.FindLikeService;
import com.chainsmoker.marronnier.member.query.domain.service.RequestMemberLikedFeed;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@InfraService
public class RequestMemberLikedFeedService implements RequestMemberLikedFeed {

    private final FindLikeService findLikeService;
    private final FindFeedService findFeedService;

    @Autowired
    public RequestMemberLikedFeedService(FindLikeService findLikeService, FindFeedService findFeedService) {
        this.findLikeService = findLikeService;
        this.findFeedService = findFeedService;
    }

    @Override
    public List<QueryFeed> findLikedFeed(long memberId) {
        List<QueryFeed> memberLikedFeedDTOList = new ArrayList<>();
        List<Long> feedIdList = findLikeService.findLikedFeedByMemberId(memberId);
        for (Long feedId: feedIdList) {
            QueryFeed feed = findFeedService.findFeedById(feedId);
            memberLikedFeedDTOList.add(feed);
        }

        return memberLikedFeedDTOList;
    }
}
