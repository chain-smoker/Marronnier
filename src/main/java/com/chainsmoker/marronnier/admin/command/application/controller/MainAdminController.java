package com.chainsmoker.marronnier.admin.command.application.controller;

import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.AdminDetail;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin")
public class MainAdminController {
    public MainAdminController() {}

    @GetMapping("home")
    public String AdminMainView(Authentication authentication, Model model) {

        if(authentication.isAuthenticated()) {
            AdminDetail admin = (AdminDetail) authentication.getPrincipal();

            model.addAttribute("adminName", admin.getUsername());
            return "admin/home";
        } else {
            return "admin/login";
        }
    }

    @PostMapping("error")
    public String AdminErrorView(HttpServletRequest request, HttpServletResponse response, Model model) {
            String errorMessage = (String) request.getAttribute("errorMessage");
            model.addAttribute("errorMessage", errorMessage);
        return "admin/error";
    }
}
