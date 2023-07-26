package com.chainsmoker.marronnier.feed.query.infra.service;

import com.chainsmoker.marronnier.cocktailrecipe.query.application.service.FindCocktailRecipeService;
import com.chainsmoker.marronnier.feed.query.domain.service.CheckCocktatilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckCocktailService implements CheckCocktatilService {
    private final FindCocktailRecipeService cocktailRecipeService;

    @Autowired
    public CheckCocktailService(FindCocktailRecipeService cocktailRecipeService) {
        this.cocktailRecipeService = cocktailRecipeService;
    }
    public String findByCocktailId(long cocktailId) {
        return cocktailRecipeService.findByCocktailRecipeId(cocktailId).getName();
    }
}
