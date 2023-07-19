package com.chainsmoker.marronnier.feed.query.domain.service;

import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;
import com.chainsmoker.marronnier.feed.query.domain.entity.QueryFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryFeedService {
    private final CheckMemberNameService checkMemberNameService;
    @Autowired
    public QueryFeedService(CheckMemberNameService checkMemberNameService) {
        this.checkMemberNameService = checkMemberNameService;
    }

    public List<CheckFeedDTO> saveInfo(List<QueryFeed> queryFeeds) {
        List<CheckFeedDTO> feedDTOS = new ArrayList<>();

        for (QueryFeed feed : queryFeeds) {
            CheckFeedDTO checkFeedDTO = new CheckFeedDTO(feed);
            feedDTOS.add(checkFeedDTO);
        }

        return feedDTOS;
    }

    public boolean isWriter(long memberId, long feedMemberId) {
        return memberId == feedMemberId;
    }

    public String feedWriter(long memberId) {
        return checkMemberNameService.findMemberNameByMemberId(memberId);
    }
}
