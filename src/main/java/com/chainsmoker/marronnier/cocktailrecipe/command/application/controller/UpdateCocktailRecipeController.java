package com.chainsmoker.marronnier.cocktailrecipe.command.application.controller;

import com.chainsmoker.marronnier.cocktailrecipe.command.application.service.UpdateCocktailRecipeService;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UpdateCocktailRecipeController {

    private UpdateCocktailRecipeService updateCocktailRecipeService;

    @Autowired
    public UpdateCocktailRecipeController(UpdateCocktailRecipeService updateCocktailRecipeService){
        this.updateCocktailRecipeService=updateCocktailRecipeService;
    }


    @GetMapping("/cocktail/update/recipe/{recipeId}")
    public String updatePicturePage(@PathVariable Long recipeId, Model model){
        model.addAttribute("recipeId",recipeId);
        return "cocktail/update/updateCocktailRecipePicture";
    }
    @PostMapping("/cocktail/update/recipe")
    public String updatePicture(@RequestParam MultipartFile photo,
                                @RequestParam PhotoCategory category,
                                @RequestParam long originId) throws IOException {

        updateCocktailRecipeService.insertPhoto(originId,photo,category);
        return "redirect:/cocktail/find/cocktailrecipe";
    }
}
