package com.chainsmoker.marronnier.feed.query.application.controller;

import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;
import com.chainsmoker.marronnier.feed.query.application.service.FindFeedService;
import com.chainsmoker.marronnier.feed.query.domain.entity.QueryFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/feed")
public class QueryFeedController {
    private final FindFeedService findFeedService;
    @Autowired
    public QueryFeedController(FindFeedService findFeedService) {
        this.findFeedService = findFeedService;
    }

    @GetMapping("")
    public String viewAllFeed(HttpSession httpSession, Model model) {
        List<CheckFeedDTO> checkFeedDTO = findFeedService.findAllFeeds();
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        System.out.println("sessionUser = " + sessionUser.getId());
        model.addAttribute("feeds",checkFeedDTO);
        return "feed/feed";
    }

    @GetMapping("/write")
    public String moveToFeedWrite(HttpSession httpSession, Model model) {
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        String memberName = sessionUser.getName();
        long memberId = sessionUser.getId();
        model.addAttribute("memberName",memberName);
        model.addAttribute("memberId",memberId);
        return "feed/write";
    }

    @GetMapping("/{feedId}")
    public String feedDetail(@PathVariable Long feedId, Model model) {
        //pathvariable에 해당하는 피드 보는 페이지
        QueryFeed queryFeed = findFeedService.findFeedById(feedId);
        model.addAttribute("feed",queryFeed);
        return "feed/detail";
    }

    @GetMapping("/update/{feedId}")
    public String moveToFeedUpdate(@PathVariable Long feedId, Model model) {
        QueryFeed queryFeed = findFeedService.findFeedById(feedId);
        model.addAttribute("feed",queryFeed);
        return "feed/update";
    }

}