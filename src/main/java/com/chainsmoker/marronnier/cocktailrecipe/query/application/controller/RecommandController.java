package com.chainsmoker.marronnier.cocktailrecipe.query.application.controller;

import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.query.application.service.RecommandService;
import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("cocktail")
public class RecommandController {
    private final RecommandService recommandService;

    public RecommandController(RecommandService recommandService) {
        this.recommandService = recommandService;
    }

    @PostMapping("recommand/second")
    public String recommandPageSecond(Model model, Authentication authentication, @RequestParam Map<String,String> recommandInfo) {
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        boolean memberIsAuthenticated = authentication.isAuthenticated();
        model.addAttribute("recommandInfo",recommandInfo.get("drink"));
        model.addAttribute("member", sessionUser);
        model.addAttribute("memberIsAuthenticated", memberIsAuthenticated);

        return "cocktail/question/second";
    }
    @PostMapping("recommand/third")
    public String recommandPageThrid(Model model, Authentication authentication,  @RequestParam Map<String,String> recommandInfo) {
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        boolean memberIsAuthenticated = authentication.isAuthenticated();

        model.addAttribute("recommandInfo1",recommandInfo.get("drink"));
        model.addAttribute("recommandInfo2",recommandInfo.get("difficulty"));
        model.addAttribute("member", sessionUser);
        model.addAttribute("memberIsAuthenticated", memberIsAuthenticated);

        return "cocktail/question/third";
    }
    @PostMapping("recommand/result")
    public String recommandCocktail(@RequestParam Map<String, String> recommandInfo, Model model, Authentication authentication) {
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        boolean memberIsAuthenticated = authentication.isAuthenticated();

        model.addAttribute("member", sessionUser);
        model.addAttribute("memberIsAuthenticated", memberIsAuthenticated);

        List<FindCocktailRecipeDTO> cocktails = recommandService.recommandCocktail(recommandInfo);

        if(cocktails.size()>1){
            Collections.shuffle(cocktails);
        }

        model.addAttribute("cocktails", cocktails);
        model.addAttribute("size", cocktails.size());
        return "cocktail/resultCocktail";
    }


}
