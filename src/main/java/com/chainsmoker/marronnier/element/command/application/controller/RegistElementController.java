package com.chainsmoker.marronnier.element.command.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// a 등록 페이지 이동 컨트롤러

@Controller
@RequestMapping("cocktail/regist")
public class RegistElementController {

    @GetMapping("/element")
    public String RegistCocktailRecipe(){
        return "cocktail/regist/element";
    }
}
