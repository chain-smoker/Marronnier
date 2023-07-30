package com.chainsmoker.marronnier.main.query.domain.service;

import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;

import java.util.List;

public interface CocktailRecipeQueryRequest {
    public List<FindCocktailRecipeDTO> searchCocktailRecipe(String searchWord);
}
