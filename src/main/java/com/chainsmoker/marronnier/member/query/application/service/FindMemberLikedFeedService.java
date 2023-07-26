package com.chainsmoker.marronnier.member.query.application.service;

import com.chainsmoker.marronnier.feed.query.domain.entity.QueryFeed;
import com.chainsmoker.marronnier.member.query.domain.service.RequestMemberLikedFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindMemberLikedFeedService {

    private final RequestMemberLikedFeed requestMemberLikedFeed;

    @Autowired
    public FindMemberLikedFeedService(RequestMemberLikedFeed requestMemberLikedFeed) {
        this.requestMemberLikedFeed = requestMemberLikedFeed;
    }

    public List<QueryFeed> findLikedFeed(long memberId) {
        return requestMemberLikedFeed.findLikedFeed(memberId);
    }
}
