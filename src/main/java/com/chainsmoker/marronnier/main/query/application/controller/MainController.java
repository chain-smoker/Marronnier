package com.chainsmoker.marronnier.main.query.application.controller;

import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class MainController {

    /* 동적 메인 페이지 연결*/
    @GetMapping("")
    public String home(Authentication authentication, Model model) {
        model.addAttribute("member", null);
        if(authentication != null) {
            SessionUser member = (SessionUser) authentication.getPrincipal();
            model.addAttribute("member", member);
        }
        return "/home";
    }
}
