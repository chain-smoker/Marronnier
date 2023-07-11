package com.chainsmoker.marronnier.feed.query.domain.service;

import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;
import com.chainsmoker.marronnier.feed.query.domain.entity.QueryFeed;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryFeedService {
    public List<CheckFeedDTO> saveInfo(List<QueryFeed> queryFeeds){
        List<CheckFeedDTO>feedDTOS = new ArrayList<>();

        for (QueryFeed feed : queryFeeds){
            CheckFeedDTO checkFeedDTO  = new CheckFeedDTO(feed);
            feedDTOS.add(checkFeedDTO);
        }

        return feedDTOS;
    }
}
