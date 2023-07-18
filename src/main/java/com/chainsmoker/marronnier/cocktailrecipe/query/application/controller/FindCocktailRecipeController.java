package com.chainsmoker.marronnier.cocktailrecipe.query.application.controller;

import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.query.application.service.FindCocktailRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("cocktail")
public class FindCocktailRecipeController {
    private final FindCocktailRecipeService findCocktailRecipeService;

    @Autowired
    public FindCocktailRecipeController(FindCocktailRecipeService findCocktailRecipeService){
        this.findCocktailRecipeService=findCocktailRecipeService;
    }
    // 삭제 HomeController에 들어갈 요청
    @GetMapping("find/main")
    public String findMain(){
        return "cocktail/findMain";
    }
    @GetMapping("find/cocktailrecipe")
    public String findAllCocktailRecipe(Model model){
        List<FindCocktailRecipeDTO> recipes=findCocktailRecipeService.findAllCocktailRecipe();
        model.addAttribute("recipes",recipes);
        return "cocktail/find/cocktailRecipe";
    }

}
