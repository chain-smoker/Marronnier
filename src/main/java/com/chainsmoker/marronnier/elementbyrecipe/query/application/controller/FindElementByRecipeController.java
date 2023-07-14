package com.chainsmoker.marronnier.elementbyrecipe.query.application.controller;

import com.chainsmoker.marronnier.element.query.application.dto.FindElementDTO;
import com.chainsmoker.marronnier.elementbyrecipe.query.application.dto.CocktailRecipeDTO;
import com.chainsmoker.marronnier.elementbyrecipe.query.application.service.FindElementByRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("find")
public class FindElementByRecipeController {

    private FindElementByRecipeService findElementByRecipeService;

    @Autowired
    public FindElementByRecipeController(FindElementByRecipeService findElementByRecipeService){
        this.findElementByRecipeService=findElementByRecipeService;
    }

    @PostMapping("/elementbyrecipe/{recipeId}")
    public String findElementByRecipe(CocktailRecipeDTO recipeDTO, @PathVariable Long recipeId, Model model){
        // 수정  현재 사용한 FindElementDTO는 Element Package에서 구현된 것
        // 수정  이걸 ElementByRecipe에서 따로 DTO를 만들어서 할까??
        model.addAttribute("recipe",recipeDTO);
        List<FindElementDTO> elements=findElementByRecipeService.findElementByRecipe(recipeId);
        model.addAttribute("elements",elements);
        return "cocktail/find/elementByrecipe";
    }
}