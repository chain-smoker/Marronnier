package com.chainsmoker.marronnier.elementbyrecipe.query.domain.service;

import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;

public interface CocktailRecipeRequest {
    public FindCocktailRecipeDTO findByCocktailRecipeId(Long cocktailrecipeId);
}
