package com.chainsmoker.marronnier.cocktailrecipe.query.application.service;

import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.query.domain.entity.QueryCocktailRecipe;
import com.chainsmoker.marronnier.cocktailrecipe.query.infra.repository.FindCocktailRecipeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindCocktailRecipeService {
    private final FindCocktailRecipeMapper findCocktailMapper;

    @Autowired
    public FindCocktailRecipeService(FindCocktailRecipeMapper findCocktailMapper){
        this.findCocktailMapper=findCocktailMapper;
    }

    public List<FindCocktailRecipeDTO> findAllCocktailRecipe(){
        List<QueryCocktailRecipe> recipes=findCocktailMapper.findAll();
        List<FindCocktailRecipeDTO> recipeDTOS=new ArrayList<>();
        for (QueryCocktailRecipe recipe:recipes ){
            recipeDTOS.add(FindCocktailRecipeDTO.entityToDTO(recipe));
        }
        return recipeDTOS;
    }
    public FindCocktailRecipeDTO findByCocktailRecipeId(Long cocktailrecipeId){
        QueryCocktailRecipe recipe=findCocktailMapper.findById(cocktailrecipeId);
        System.out.println("QueryCocktailRecipe = " + recipe);
        FindCocktailRecipeDTO recipeDTO=FindCocktailRecipeDTO.entityToDTO(recipe);
        return recipeDTO;
    }
}
