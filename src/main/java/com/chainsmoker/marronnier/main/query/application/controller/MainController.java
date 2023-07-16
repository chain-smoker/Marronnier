package com.chainsmoker.marronnier.main.query.application.controller;

import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/home")
public class MainController {

    @GetMapping("")
    public String homeView(Authentication authentication, Model model) {

        SessionUser member = (SessionUser) authentication.getPrincipal();
        model.addAttribute("member", member);
        return "main/home";
    }
}
