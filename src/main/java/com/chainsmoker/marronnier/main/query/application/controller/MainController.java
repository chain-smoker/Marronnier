package com.chainsmoker.marronnier.main.query.application.controller;

import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.AdminDetail;
import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.EnumType.AdminRole;
import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.Role;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MainController {

    /* 동적 메인 페이지 연결*/
    @GetMapping({"", "home"})
    public String home(Authentication authentication, Model model) {
        if(authentication != null) {
            if (authentication.getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(Role.MEMBER.getKey()))) {
                SessionUser member = (SessionUser) authentication.getPrincipal();
                model.addAttribute("member", member);
            } else if (authentication.getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(AdminRole.ADMIN.getKey()))) {
                AdminDetail admin = (AdminDetail) authentication.getPrincipal();
                model.addAttribute("admin", admin);
            }
        }
        return "home";
    }
    @GetMapping("cocktail/recommand/first")
    public String recommandPage(Model model, Authentication authentication){
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        boolean memberIsAuthenticated = authentication.isAuthenticated();

        model.addAttribute("member", sessionUser);
        model.addAttribute("memberIsAuthenticated", memberIsAuthenticated);

        return "cocktail/question/first";
    }
}
