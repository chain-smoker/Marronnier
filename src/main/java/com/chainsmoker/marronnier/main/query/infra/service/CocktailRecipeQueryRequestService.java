package com.chainsmoker.marronnier.main.query.infra.service;

import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.query.application.service.SearchCocktailRecipeService;
import com.chainsmoker.marronnier.common.annotation.InfraService;
import com.chainsmoker.marronnier.main.query.domain.service.CocktailRecipeQueryRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@InfraService
public class CocktailRecipeQueryRequestService implements CocktailRecipeQueryRequest {

    private final SearchCocktailRecipeService searchCocktailRecipeService;

    @Autowired
    public CocktailRecipeQueryRequestService(SearchCocktailRecipeService searchCocktailRecipeService){
        this.searchCocktailRecipeService=searchCocktailRecipeService;
    }

    @Override
    public List<FindCocktailRecipeDTO> searchCocktailRecipe(String searchWord){
        return  searchCocktailRecipeService.searchCocktailRecipe(searchWord);
    }
}
