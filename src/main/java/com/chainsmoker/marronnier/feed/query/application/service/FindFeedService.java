package com.chainsmoker.marronnier.feed.query.application.service;

import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;
import com.chainsmoker.marronnier.feed.query.domain.entity.QueryFeed;
import com.chainsmoker.marronnier.feed.query.domain.service.QueryFeedService;
import com.chainsmoker.marronnier.feed.query.infra.repository.FeedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindFeedService {
    private final FeedMapper feedMapper;
    private final QueryFeedService queryFeedService;

    @Autowired
    public FindFeedService(FeedMapper feedMapper, QueryFeedService queryFeedService) {
        this.feedMapper = feedMapper;
        this.queryFeedService = queryFeedService;
    }

    public List<CheckFeedDTO> findAllFeeds() {
        List<QueryFeed> queryFeeds = feedMapper.findAllFeeds();
        List<CheckFeedDTO> checkFeedDTOS = queryFeedService.saveInfo(queryFeeds);
        return checkFeedDTOS;
    }

    public QueryFeed findFeedById(Long feedId) {
        QueryFeed queryFeed = feedMapper.findFeedById(feedId);
        return queryFeed;
    }

    public long findFeedMemberId(long feedId) {
        long feedMemberId = feedMapper.findFeedMemberIdByFeedId(feedId);

        return feedMemberId;
    }
}
