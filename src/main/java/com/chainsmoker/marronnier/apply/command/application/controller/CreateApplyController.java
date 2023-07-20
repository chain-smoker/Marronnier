package com.chainsmoker.marronnier.apply.command.application.controller;

import com.chainsmoker.marronnier.apply.command.application.dto.CreateApplyDTO;
import com.chainsmoker.marronnier.apply.command.application.service.RegistApplyService;
import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/apply/*")
public class CreateApplyController {

    private final RegistApplyService registApplyService;

    @Autowired
    public CreateApplyController(RegistApplyService registApplyService) {
        this.registApplyService = registApplyService;
    }

    @GetMapping("add")
    public String addApplyView(Authentication authentication, Model model) {
        SessionUser member = (SessionUser) authentication.getPrincipal();
        boolean memberIsAuthenticated = authentication.isAuthenticated();
        model.addAttribute("member", member);
        model.addAttribute("memberIsAuthenticated", memberIsAuthenticated);
        return "apply/add";
    }

    @PostMapping("add")
    public String addApply(CreateApplyDTO createApplyDTO,
                           Authentication authentication) {

        // 로그인된 사용자 id 가져오기
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        long requesterId = sessionUser.getId();

        // 요청자 아이디 담기
        createApplyDTO.setRequesterId(requesterId);

        registApplyService.create(createApplyDTO);

        return "redirect:/member/profile";
    }

}
