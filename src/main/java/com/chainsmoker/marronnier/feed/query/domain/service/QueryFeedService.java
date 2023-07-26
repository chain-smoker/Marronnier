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
    private final CheckLikeService checkLikeService;
    @Autowired
    public QueryFeedService(CheckMemberService checkMemberService, CheckLikeService checkLikeService) {
        this.checkMemberService = checkMemberService;
        this.checkLikeService = checkLikeService;
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

    public void addDetails(List<CheckFeedDTO> checkFeedDTOS) {
        for(int i = 0 ; i <checkFeedDTOS.size(); i++){
            long feedId= checkFeedDTOS.get(i).getId();
            long memberId= checkFeedDTOS.get(i).getMemberId();
            checkFeedDTOS.get(i).setLike(checkLikeService.numberOfLike(feedId));
            FindMemberDTO writer =checkMemberService.findById(memberId);
            checkFeedDTOS.get(i).setWriter(writer.getName());
            checkFeedDTOS.get(i).setProfileImage(writer.getProfileImage());
        }
    }
}
