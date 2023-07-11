package com.chainsmoker.marronnier.feed.query.application.service;

import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;
import com.chainsmoker.marronnier.feed.query.domain.entity.QueryFeed;
import com.chainsmoker.marronnier.feed.query.domain.service.QueryFeedService;
import com.chainsmoker.marronnier.feed.query.infra.repository.FeedMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindFeedService {
    private final FeedMapper feedMapper;
    private final QueryFeedService queryFeedService;

    public List<CheckFeedDTO> findAllFeeds() {
        List<QueryFeed> queryFeeds = feedMapper.findAllFeeds();
        List<CheckFeedDTO> checkFeedDTOS = queryFeedService.saveInfo(queryFeeds);
        return checkFeedDTOS;
    }
}
