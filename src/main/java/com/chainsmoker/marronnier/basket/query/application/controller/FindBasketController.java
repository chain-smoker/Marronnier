package com.chainsmoker.marronnier.basket.query.application.controller;

import com.chainsmoker.marronnier.basket.query.application.service.FindBasketService;
import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.basket.query.application.dto.MemberCockTailBasketDTO;
import com.chainsmoker.marronnier.member.query.application.dto.FindBasketsPaginationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/basket")
@SessionAttributes("user")
public class FindBasketController {

    private final FindBasketService findBasketService;

    @Autowired
    public FindBasketController (FindBasketService findBasketService) {
        this.findBasketService = findBasketService;
    }

    @GetMapping("/list")
    public String findCockTailBaskets(Authentication authentication, Model model) {
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        long memberId = sessionUser.getId();
        List<MemberCockTailBasketDTO> memberCockTailBasketDTOs = findBasketService.findAllByMemberId(memberId);
        model.addAttribute("memberCockTailBaskets", memberCockTailBasketDTOs);
        return "basket/memberBaskets";
    }

    @GetMapping("")
    public String findCockTailBasketsPagination(@RequestParam int page, Authentication authentication, Model model) {
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        boolean memberIsAuthenticated = authentication.isAuthenticated();
        long memberId = sessionUser.getId();
        FindBasketsPaginationDTO findBasketsPaginationDTO = findBasketService.findAllByMemberIdPagination(memberId, page);

        int totalPages = findBasketsPaginationDTO.getTotalPage();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("basketPages", findBasketsPaginationDTO.getBasketPages());
        model.addAttribute("baskets", findBasketsPaginationDTO.getBaskets());
        model.addAttribute("memberIsAuthenticated", memberIsAuthenticated);
        model.addAttribute("member", sessionUser);
        return "basket/memberBaskets";
    }
}
