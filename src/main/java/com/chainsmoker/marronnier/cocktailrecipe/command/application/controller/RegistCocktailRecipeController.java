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
    private final RegistCocktailRecipeService cocktailRecipeService;
    @Autowired
    public RegistCocktailRecipeController(RegistCocktailRecipeService cocktailRecipeService){
        this.cocktailRecipeService=cocktailRecipeService;
    }


    //a Regist
    //a HomeController에 들어갈 요청
    @GetMapping("/main")
    public String Regist(){
        return "cocktail/registmain";
    }
    @GetMapping("/cocktailrecipe")
    public String RegistCocktailRecipe(){
        return "cocktail/regist/cocktailrecipe";
    }

    //a Regist

    @PostMapping("/cocktailrecipe")
    public String Regist(RegistCocktailRecipeDTO recipeDTO){
        cocktailRecipeService.regist(recipeDTO);
        return "cocktail/registmain";
    }

}
