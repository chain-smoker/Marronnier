package com.chainsmoker.marronnier.basket.query.infra.service;

import com.chainsmoker.marronnier.basket.query.domain.service.CocktailRecipeRequest;
import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.query.application.service.FindCocktailRecipeService;
import com.chainsmoker.marronnier.common.annotation.InfraService;
import org.springframework.beans.factory.annotation.Autowired;

@InfraService
public class CocktailRecipeRequestService implements CocktailRecipeRequest {

    private final FindCocktailRecipeService findCocktailRecipeService;
    @Autowired
    public CocktailRecipeRequestService(FindCocktailRecipeService findCocktailRecipeService) {
        this.findCocktailRecipeService = findCocktailRecipeService;
    }
    @Override
    public FindCocktailRecipeDTO getCocktailRecipeById(long cocktailRecipeId) {
        return findCocktailRecipeService.findByCocktailRecipeId(cocktailRecipeId);
    }
}
