package com.chainsmoker.marronnier.elementbyrecipe.query.infra.service;

import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.query.application.service.FindCocktailRecipeService;
import com.chainsmoker.marronnier.common.annotation.InfraService;
import com.chainsmoker.marronnier.elementbyrecipe.query.domain.service.CocktailRecipeRequest;
import org.springframework.beans.factory.annotation.Autowired;

@InfraService
//수정 class이름 수정 필요 
public class RecipeRequestService implements CocktailRecipeRequest {
    private final FindCocktailRecipeService findCocktailRecipeService;

    @Autowired
    public RecipeRequestService(FindCocktailRecipeService findCocktailRecipeService){
        this.findCocktailRecipeService=findCocktailRecipeService;
    }

    @Override
    public FindCocktailRecipeDTO findByCocktailRecipeId(Long cocktailrecipeId){
        return findCocktailRecipeService.findByCocktailRecipeId(cocktailrecipeId);
    }
}
