package com.chainsmoker.marronnier.member.query.infra.service;


import com.chainsmoker.marronnier.common.annotation.InfraService;
import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;
import com.chainsmoker.marronnier.feed.query.domain.service.QueryFeedService;
import com.chainsmoker.marronnier.member.query.domain.service.RequestMemberWroteFeed;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@InfraService
public class RequestMemberWroteFeedService implements RequestMemberWroteFeed {

    private final QueryFeedService queryFeedService;

    @Autowired
    public RequestMemberWroteFeedService(QueryFeedService queryFeedService) {
        this.queryFeedService = queryFeedService;
    }

    @Override
    public List<CheckFeedDTO> findWroteFeed(long memberId) {
        return queryFeedService.findFeedsByMemberId(memberId);
    }
}
