package com.chainsmoker.marronnier.basket.query.application.controller;

import com.chainsmoker.marronnier.basket.query.application.service.FindBasketService;
import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.basket.query.application.dto.MemberCockTailBasketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/basket")
@SessionAttributes("user")
public class FindBasketController {

    private final FindBasketService findBasketService;

    @Autowired
    public FindBasketController (FindBasketService findBasketService) {
        this.findBasketService = findBasketService;
    }

    @GetMapping("")
    public String findCockTailBaskets(Authentication authentication, Model model) {
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        long memberId = sessionUser.getId();
        List<MemberCockTailBasketDTO> memberCockTailBasketDTOs = findBasketService.findByMemberId(memberId);
        model.addAttribute("memberCockTailBaskets", memberCockTailBasketDTOs);
        return "basket/memberBaskets";
    }
}
