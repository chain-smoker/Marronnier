package com.chainsmoker.marronnier.feed.query.application.controller;

import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;
import com.chainsmoker.marronnier.feed.query.application.service.FindFeedService;
import com.chainsmoker.marronnier.feed.query.domain.entity.QueryFeed;
import com.chainsmoker.marronnier.feed.query.domain.service.LikeService;
import com.chainsmoker.marronnier.feed.query.domain.service.QueryFeedService;
import com.chainsmoker.marronnier.member.query.application.dto.FindMemberDTO;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.query.application.dto.FindPhotoDTO;
import org.checkerframework.checker.units.qual.C;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/feed")
public class QueryFeedController {
    private final FindFeedService findFeedService;
    private final LikeService likeService;
    private final QueryFeedService queryFeedService;


    @Autowired
    public QueryFeedController(FindFeedService findFeedService, LikeService likeService, QueryFeedService queryFeedService) {
        this.findFeedService = findFeedService;
        this.likeService = likeService;
        this.queryFeedService = queryFeedService;
    }

    @GetMapping("")
    public String viewAllFeed(Authentication authentication, Model model) {
        boolean memberIsAuthenticated = authentication.isAuthenticated();
        List<CheckFeedDTO> checkFeedDTO = findFeedService.findAllFeeds();
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        FindMemberDTO member = queryFeedService.findMemberById(sessionUser.getId());
        queryFeedService.addDetails(checkFeedDTO);
        model.addAttribute("feeds", checkFeedDTO);
        model.addAttribute("memberIsAuthenticated", memberIsAuthenticated);
        model.addAttribute("member",member);
        return "feed/feed";
    }

    @GetMapping("/write/{cocktailRecipeId}")
    public String moveToFeedWrite(Authentication authentication, Model model,@PathVariable(name = "cocktailRecipeId") long cocktailId) {
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        FindMemberDTO member = queryFeedService.findMemberById(sessionUser.getId());
        boolean memberIsAuthenticated = authentication.isAuthenticated();
        String cocktailName = queryFeedService.findCocktailNameById(cocktailId);
        model.addAttribute("member",member);
        model.addAttribute("memberIsAuthenticated", memberIsAuthenticated);
        model.addAttribute("cocktailName",cocktailName);
        model.addAttribute("cocktailId",cocktailId);
        return "feed/write";
    }

    @GetMapping("/{feedId}")
    @ResponseBody
    public Map<String, Object> feedDetail(Authentication authentication, @PathVariable long feedId) {
        Map<String, Object> info = new HashMap<>();
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        long memberId = sessionUser.getId();
        Map<String, Long> parameter = new HashMap<>();
        parameter.put("memberId", memberId);//current user Id
        parameter.put("feedId",feedId);//feed Id

        CheckFeedDTO checkFeedDTO =  new CheckFeedDTO(findFeedService.findFeedById(feedId));
        queryFeedService.addDetails(checkFeedDTO);
        info.put("cocktailName", checkFeedDTO.getCocktailName());
        info.put("feed", checkFeedDTO);//feed info
        info.put("memberId", memberId);//current user iD
        info.put("feedId",feedId);//feed Id
        info.put("whetherLike",likeService.checkLike(parameter));//whether like
        info.put("NumberOfLike",likeService.numberOfLikes(feedId));//number of like

        List<FindPhotoDTO> photoDTOS = findFeedService.findPhotoByIdAndCategory(feedId, PhotoCategory.valueOf("FEED"));
        if(photoDTOS.size()>0){
            info.put("photo",photoDTOS.get(0).getPhotoRoot());
        }
        else{
            info.put("photo","https://picsum.photos/250/250");
        }
        //작성자확인
        long feedMemberId = findFeedService.findFeedMemberId(feedId);
        FindMemberDTO writer = queryFeedService.findMemberById(feedMemberId);
        info.put("feedWriter",writer);//feed writer name
        info.put("whetherWriter", queryFeedService.isWriter(memberId,feedMemberId));//whether writer
        return info;
    }

    @GetMapping("/update/{feedId}")
    public String moveToFeedUpdate(Authentication authentication, @PathVariable Long feedId, Model model) {
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        QueryFeed queryFeed = findFeedService.findFeedById(feedId);
        CheckFeedDTO checkFeedDTO= new CheckFeedDTO(queryFeed);
        queryFeedService.addDetails(checkFeedDTO);
        model.addAttribute("feed", checkFeedDTO);
        FindMemberDTO member = queryFeedService.findMemberById(sessionUser.getId());
        boolean memberIsAuthenticated = authentication.isAuthenticated();
        model.addAttribute("member",member);
        model.addAttribute("memberIsAuthenticated", memberIsAuthenticated);
        return "feed/update";
    }

}