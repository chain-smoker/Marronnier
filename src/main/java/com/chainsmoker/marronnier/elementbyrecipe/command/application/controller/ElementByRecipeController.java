package com.chainsmoker.marronnier.elementbyrecipe.command.application.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// a 등록 페이지 이동 컨트롤러
@Controller
@RequestMapping("regist")
public class ElementByRecipeController {

    @GetMapping("elementbyrecipe")
    public String RegistCocktailRecipe(){
        return "cocktail/elementbyrecipe/elementbyrecipe";
    }

}



