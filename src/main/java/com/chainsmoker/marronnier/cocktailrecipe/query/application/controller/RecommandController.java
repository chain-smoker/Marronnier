package com.chainsmoker.marronnier.cocktailrecipe.query.application.controller;

import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.query.application.service.RecommandService;
import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("cocktail")
public class RecommandController {
    private final RecommandService recommandService;

    public RecommandController(RecommandService recommandService){
        this.recommandService=recommandService;
    }

//    @GetMapping("recommand")
//    public String  recommandCocktail(){
//        Map<String ,String> map=new HashMap<>();
//        recommandService.recommandCocktail(map);
//        return "cocktail/recommand";
//    }
    @GetMapping("recommand")
    public String recommandPage(){
        return "cocktail/question";
    }

    @PostMapping("recommand")
    public String recommandCocktail(@RequestParam Map<String, String> recommandInfo, Model model, Authentication authentication){
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
//        model.addAttribute("memberIsAuthenticated", authentication.isAuthenticated());
        model.addAttribute("member", sessionUser);

        List<FindCocktailRecipeDTO> cocktails=recommandService.recommandCocktail(recommandInfo);
        model.addAttribute("cocktails",cocktails);
        //추가 세션에 있는 memeber정보도 가져와야함
        return "cocktail/resultCocktail";
    }


}
