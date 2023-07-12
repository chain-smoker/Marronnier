package com.chainsmoker.marronnier.cocktailrecipe.command.application.controller;

import com.chainsmoker.marronnier.cocktailrecipe.command.application.dto.RegistCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.command.application.service.RegistCocktailRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// a 등록 페이지 이동 컨트롤러

@Controller
@RequestMapping("regist")
public class RegistCocktailRecipeController {
    private final RegistCocktailRecipeService registCocktailRecipeService;
    @Autowired
    public RegistCocktailRecipeController(RegistCocktailRecipeService cocktailRecipeService){
        this.registCocktailRecipeService=cocktailRecipeService;
    }


    //a Regist
    //a HomeController에 들어갈 요청
    @GetMapping("/main")
    public String registMain(){
        return "cocktail/registMain";
    }
    @GetMapping("/cocktailrecipe")
    public String registCocktailRecipe(){
        return "cocktail/regist/cocktailRecipe";
    }

    //a Regist

    @PostMapping("/cocktailrecipe")
    public String regist(RegistCocktailRecipeDTO recipeDTO){
        registCocktailRecipeService.regist(recipeDTO);
        return "cocktail/registMain";
    }

}
