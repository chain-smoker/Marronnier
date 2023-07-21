package com.chainsmoker.marronnier.feed.query.domain.service;

import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;
import com.chainsmoker.marronnier.feed.query.domain.entity.QueryFeed;
import com.chainsmoker.marronnier.member.query.application.dto.FindMemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryFeedService {
    private final CheckMemberService checkMemberService;
    @Autowired
    public QueryFeedService(CheckMemberService checkMemberService) {
        this.checkMemberService = checkMemberService;
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
        return checkMemberService.findMemberNameByMemberId(memberId);
    }
    public FindMemberDTO findMemberById(long memberId){
        return checkMemberService.findById(memberId);
    }
}
