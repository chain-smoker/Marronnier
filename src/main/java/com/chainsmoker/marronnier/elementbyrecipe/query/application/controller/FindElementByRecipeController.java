package com.chainsmoker.marronnier.elementbyrecipe.query.application.controller;

import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.element.query.application.dto.FindElementDTO;
import com.chainsmoker.marronnier.elementbyrecipe.query.application.dto.CocktailRecipeDTO;
import com.chainsmoker.marronnier.elementbyrecipe.query.application.service.FindElementByRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("cocktail")
public class FindElementByRecipeController {

    private FindElementByRecipeService findElementByRecipeService;

    @Autowired
    public FindElementByRecipeController(FindElementByRecipeService findElementByRecipeService) {
        this.findElementByRecipeService = findElementByRecipeService;
    }

    @GetMapping("find/elementbyrecipe/{recipeId}")
    public String findElementByRecipe(@PathVariable Long recipeId, Model model, Authentication authentication) {
        // 수정  현재 사용한 FindElementDTO는 Element Package에서 구현된 것
        // 수정  이걸 ElementByRecipe에서 따로 DTO를 만들어서 할까??
        FindCocktailRecipeDTO cocktailRecipe = findElementByRecipeService.findRecipeById(recipeId);
        String[] recipes = cocktailRecipe.getRecipe().split("-");
        int recipesSize = recipes.length;
        List<String> recipe = new ArrayList<>();
        for (int i = 0; i < recipesSize; i++) {
            recipe.add(recipes[i]);
        }
        model.addAttribute("recipes", recipe);
        model.addAttribute("cocktailRecipe", cocktailRecipe);


        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        boolean memberIsAuthenticated = authentication.isAuthenticated();
        model.addAttribute("member", sessionUser);
        model.addAttribute("memberIsAuthenticated", memberIsAuthenticated);
        List<FindElementDTO> elements = findElementByRecipeService.findElementByRecipe(recipeId);
        model.addAttribute("elements", elements);
        return "cocktail/find/elementByrecipe";
    }
}