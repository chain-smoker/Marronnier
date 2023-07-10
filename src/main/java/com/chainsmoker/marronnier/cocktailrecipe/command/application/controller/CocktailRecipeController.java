package com.chainsmoker.marronnier.cocktailrecipe.command.application.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// a 등록 페이지 이동 컨트롤러

@Controller
@RequestMapping("regist")
public class CocktailRecipeController {

    //a HomeController에 들어갈 요청
    @GetMapping(" ")
    public String Regist(){
        return "cocktail/regist";
    }
    @GetMapping("cocktailrecipe")
    public String RegistCocktailRecipe(){
        return "cocktail/cocktailrecipe/cocktailrecipe";
    }
}
