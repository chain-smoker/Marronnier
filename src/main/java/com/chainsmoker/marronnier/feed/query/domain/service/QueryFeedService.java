package com.chainsmoker.marronnier.feed.query.domain.service;

import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;
import com.chainsmoker.marronnier.feed.query.domain.entity.QueryFeed;
import com.chainsmoker.marronnier.feed.query.infra.repository.FeedMapper;
import com.chainsmoker.marronnier.member.query.application.dto.FindMemberDTO;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.query.application.dto.FindPhotoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueryFeedService {
    private final CheckMemberService checkMemberService;
    private final CheckLikeService checkLikeService;
    private final CheckCocktatilService checkCocktatilService;
    private  final FeedMapper feedMapper;
    private final CheckPhotoService checkPhotoService;
    @Autowired
    public QueryFeedService(CheckMemberService checkMemberService, CheckLikeService checkLikeService, CheckCocktatilService checkCocktatilService, FeedMapper feedMapper, CheckPhotoService checkPhotoService) {
        this.checkMemberService = checkMemberService;
        this.checkLikeService = checkLikeService;
        this.checkCocktatilService = checkCocktatilService;
        this.feedMapper = feedMapper;
        this.checkPhotoService = checkPhotoService;
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
            List<FindPhotoDTO> photo = checkPhotoService.findPhotoByIdAndCategory(feedId, PhotoCategory.valueOf("FEED"));
            System.out.println(photo.size());
            if(photo.size()>0){
                checkFeedDTOS.get(i).setPhotoRoot(photo.get(0).getPhotoRoot());
            }else{
                checkFeedDTOS.get(i).setPhotoRoot("https://picsum.photos/250/250");
            }
        }

        Comparator<CheckFeedDTO> compareTime = (dto1,dto2)->dto2.getCreatedDate().compareTo(dto1.getCreatedDate());

        Collections.sort(checkFeedDTOS,compareTime);
    }

    public void addDetails(CheckFeedDTO checkFeedDTO) {
            long feedId= checkFeedDTO.getId();
            long memberId= checkFeedDTO.getMemberId();
            long cocktailId = checkFeedDTO.getCocktailId();
            checkFeedDTO.setLike(checkLikeService.numberOfLike(feedId));
            FindMemberDTO writer =checkMemberService.findById(memberId);
            checkFeedDTO.setWriter(writer.getName());
            checkFeedDTO.setProfileImage(writer.getProfileImage());
            checkFeedDTO.setCocktailName(findCocktailNameById(cocktailId));
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
