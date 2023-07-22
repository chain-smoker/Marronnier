package com.chainsmoker.marronnier.member.query.application.controller;

import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.member.query.application.dto.FindMemberDTO;
import com.chainsmoker.marronnier.member.query.application.service.FindMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("member")
@Controller
public class MemberProfileController {

    private final FindMemberService findMemberService;

    @Autowired
    public MemberProfileController(FindMemberService findMemberService) {
        this.findMemberService = findMemberService;
    }

    @GetMapping("/profile")
    public String getProfile(Authentication authentication, Model model) {

        SessionUser authenticationMember = (SessionUser) authentication.getPrincipal();
        boolean memberIsAuthenticated = authentication.isAuthenticated();
        FindMemberDTO member = findMemberService.findById(authenticationMember.getId());

        //List<MemberCockTailBasketDTO> baskets = requestMemberBasket.findBasketByMemberId(member.getId());
        model.addAttribute("member", member);
        //model.addAttribute("baskets", baskets);
        model.addAttribute("memberIsAuthenticated", memberIsAuthenticated);

        return "member/profile";
    }
}
