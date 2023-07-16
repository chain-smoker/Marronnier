package com.chainsmoker.marronnier.basket.query.domain.service;


import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;

public interface CocktailRecipeRequest {
    FindCocktailRecipeDTO getCocktailRecipeById(long cocktailRecipeId);
}
