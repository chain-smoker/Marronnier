package com.chainsmoker.marronnier.member.query.application.controller;

import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;
import com.chainsmoker.marronnier.member.query.application.dto.FindMemberDTO;
import com.chainsmoker.marronnier.member.query.application.service.FindMemberLikedFeedService;
import com.chainsmoker.marronnier.member.query.application.service.FindMemberService;
import com.chainsmoker.marronnier.member.query.application.service.FindMemberWroteFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@RequestMapping("member")
@Controller
public class MemberProfileController {

    private final FindMemberService findMemberService;
    private final FindMemberLikedFeedService findMemberLikedFeedService;
    private final FindMemberWroteFeedService findMemberWroteFeedService;

    @Autowired
    public MemberProfileController(FindMemberService findMemberService,
                                   FindMemberLikedFeedService findMemberLikedFeedService,
                                   FindMemberWroteFeedService findMemberWroteFeedService) {
        this.findMemberService = findMemberService;
        this.findMemberLikedFeedService = findMemberLikedFeedService;
        this.findMemberWroteFeedService = findMemberWroteFeedService;
    }

    @GetMapping("/profile")
    public String getProfile(Authentication authentication, Model model, @RequestParam(name = "feed", defaultValue = "wrote") String feedCategory) {

        SessionUser authenticationMember = (SessionUser) authentication.getPrincipal();
        boolean memberIsAuthenticated = authentication.isAuthenticated();
        long memberId = authenticationMember.getId();
        FindMemberDTO member = findMemberService.findById(memberId);

        model.addAttribute("member", member);
        model.addAttribute("memberIsAuthenticated", memberIsAuthenticated);
        model.addAttribute("feedCategory", feedCategory);

        if(feedCategory.equals("wrote")) {
            List<CheckFeedDTO> memberWroteFeedList = findMemberWroteFeedService.findWroteFeed(memberId);
            model.addAttribute("feedList", memberWroteFeedList);
        } else if (feedCategory.equals("like")) {
            List<CheckFeedDTO> memberLikedFeedList = findMemberLikedFeedService.findLikedFeed(memberId);
            model.addAttribute("feedList", memberLikedFeedList);
        }

        return "member/profile";
    }
}
