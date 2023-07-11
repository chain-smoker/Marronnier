package com.chainsmoker.marronnier.cocktailrecipe.query.application.service;

import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.query.domain.entity.QueryCocktailRecipe;
import com.chainsmoker.marronnier.cocktailrecipe.query.infra.repository.FindCocktailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindCocktailRecipeService {
    private final FindCocktailMapper findCocktailMapper;

    @Autowired
    public FindCocktailRecipeService(FindCocktailMapper findCocktailMapper){
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
}
