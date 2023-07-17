package com.chainsmoker.marronnier.feed.query.application.controller;

import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;
import com.chainsmoker.marronnier.feed.query.application.service.FindFeedService;
import com.chainsmoker.marronnier.feed.query.domain.entity.QueryFeed;
import com.chainsmoker.marronnier.feed.query.domain.service.LikeService;
import com.chainsmoker.marronnier.feed.query.domain.service.QueryFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<CheckFeedDTO> checkFeedDTO = findFeedService.findAllFeeds();
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        model.addAttribute("feeds", checkFeedDTO);
        return "feed/feed";
    }

    @GetMapping("/write")
    public String moveToFeedWrite(Authentication authentication, Model model) {
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        String memberName = sessionUser.getName();
        long memberId = sessionUser.getId();
        model.addAttribute("memberName", memberName);
        model.addAttribute("memberId", memberId);
        return "feed/write";
    }

    @GetMapping("/{feedId}")
    public String feedDetail(Authentication authentication, @PathVariable long feedId, Model model) {
        //pathvariable에 해당하는 피드 보는 페이지
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        long memberId = sessionUser.getId();
        //session에서 \memberId 조회

        QueryFeed queryFeed = findFeedService.findFeedById(feedId);
        model.addAttribute("feed", queryFeed);
        Map<String, Long> parameter = new HashMap<>();
        parameter.put("memberId", memberId);
        parameter.put("feedId",feedId);
        //memberId로 좋아요를 했는지 확인
        model.addAttribute("whetherLike",likeService.checkLike(parameter));
        model.addAttribute("NumberoFlIKE",likeService.numberOfLikes(feedId));

        //작성자확인
        long feedMemberId = findFeedService.findFeedMemberId(feedId);
        model.addAttribute("whetherWriter", queryFeedService.isWriter(memberId,feedMemberId));
        return "feed/detail";
    }

    @GetMapping("/update/{feedId}")
    public String moveToFeedUpdate(@PathVariable Long feedId, Model model) {
        QueryFeed queryFeed = findFeedService.findFeedById(feedId);
        model.addAttribute("feed", queryFeed);
        return "feed/update";
    }

}