package com.chainsmoker.marronnier.elementbyrecipe.command.application.controller;


import com.chainsmoker.marronnier.elementbyrecipe.command.application.dto.RegistElementByRecipeDTO;
import com.chainsmoker.marronnier.elementbyrecipe.command.application.service.RegistElementByRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// a 등록 페이지 이동 컨트롤러
@Controller
@RequestMapping("cocktail/regist")
public class RegistElementByRecipeController {

    private final RegistElementByRecipeService registElementByRecipeService;

    @Autowired
    public RegistElementByRecipeController(RegistElementByRecipeService registElementByRecipeService){
        this.registElementByRecipeService=registElementByRecipeService;
    }

    @GetMapping("/elementbyrecipe")
    public String registElementByRecipe(){
        return "cocktail/regist/elementByrecipe";
    }

    @PostMapping("regist/elementbyrecipe")
    public String regist(RegistElementByRecipeDTO recipeDTO){
        registElementByRecipeService.regist(recipeDTO);
        return "cocktail/registMain";
    }
}



