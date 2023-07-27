package com.chainsmoker.marronnier.member.query.application.service;


import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;
import com.chainsmoker.marronnier.member.query.domain.service.RequestMemberWroteFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindMemberWroteFeedService {

    private final RequestMemberWroteFeed requestMemberWroteFeed;

    @Autowired
    public FindMemberWroteFeedService(RequestMemberWroteFeed requestMemberWroteFeed) {
        this.requestMemberWroteFeed = requestMemberWroteFeed;
    }

    public List<CheckFeedDTO> findWroteFeed(long memberId) {
        return requestMemberWroteFeed.findWroteFeed(memberId);
    }
}
