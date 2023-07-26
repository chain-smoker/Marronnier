package com.chainsmoker.marronnier.feed.query.domain.service;

import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;
import com.chainsmoker.marronnier.feed.query.application.service.FindFeedService;
import com.chainsmoker.marronnier.feed.query.domain.entity.QueryFeed;
import com.chainsmoker.marronnier.feed.query.domain.repository.FeedMapper;
import com.chainsmoker.marronnier.member.query.application.dto.FindMemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryFeedService {
    private final CheckMemberService checkMemberService;
    private final CheckLikeService checkLikeService;
    private final CheckCocktatilService checkCocktatilService;
    private  final FeedMapper feedMapper;
    @Autowired
    public QueryFeedService(CheckMemberService checkMemberService, CheckLikeService checkLikeService, CheckCocktatilService checkCocktatilService,  FeedMapper feedMapper) {
        this.checkMemberService = checkMemberService;
        this.checkLikeService = checkLikeService;
        this.checkCocktatilService = checkCocktatilService;
        this.feedMapper = feedMapper;
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
            long cocktailId = checkFeedDTOS.get(i).getCocktailId();
            checkFeedDTOS.get(i).setLike(checkLikeService.numberOfLike(feedId));
            FindMemberDTO writer =checkMemberService.findById(memberId);
            checkFeedDTOS.get(i).setWriter(writer.getName());
            checkFeedDTOS.get(i).setProfileImage(writer.getProfileImage());
            checkFeedDTOS.get(i).setCocktailName(findCocktailNameById(cocktailId));
        }
    }
    public String findCocktailNameById(long cocktailId){
        return checkCocktatilService.findByCocktailId(cocktailId);
    }

    public List<CheckFeedDTO> findFeedsByMemberId(long memberId){
        List<QueryFeed> list = feedMapper.findFeedsByMemberId(memberId);
        List<CheckFeedDTO> res = new ArrayList<>();
        for (int i =0 ; i<list.size();i++){
            res.add(new CheckFeedDTO(list.get(i)));
        }
        addDetails(res);
        return res;
    }
}
