package com.chainsmoker.marronnier.like.query.infra.service;

import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;
import com.chainsmoker.marronnier.feed.query.application.service.FindFeedService;
import com.chainsmoker.marronnier.feed.query.domain.service.QueryFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckFeedService implements com.chainsmoker.marronnier.like.query.domain.service.CheckFeedService {
    private final FindFeedService findFeedService;
    private final QueryFeedService queryFeedService;
    @Autowired
    public CheckFeedService(FindFeedService findFeedService, QueryFeedService queryFeedService) {
        this.findFeedService = findFeedService;
        this.queryFeedService = queryFeedService;
    }

    public List<CheckFeedDTO> findLikedFeedsById(List<Long> feedIds){
        List<CheckFeedDTO> list = new ArrayList<>();
        for(int i = 0; i<feedIds.size();i++){
            list.add(new CheckFeedDTO(findFeedService.findFeedById(feedIds.get(i))));
        }
        queryFeedService.addDetails(list);
        return list;
    }

}
