package com.chainsmoker.marronnier.cocktailrecipe.query.application.service;

import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.query.domain.entity.QueryCocktailRecipe;
import com.chainsmoker.marronnier.cocktailrecipe.query.infra.repository.RecommandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RecommandService {

    private final RecommandMapper recommandMapper;

    @Autowired
    public RecommandService(RecommandMapper recommandMapper){
        this.recommandMapper=recommandMapper;
    }

    public List<FindCocktailRecipeDTO> recommandCocktail(Map<String, String> recommandInfo){
        List<QueryCocktailRecipe> recipes=recommandMapper.findRecommandCocktail(recommandInfo);
        List<FindCocktailRecipeDTO> recipeDTOS=new ArrayList<>();
        for (QueryCocktailRecipe recipe:recipes){
            recipeDTOS.add(FindCocktailRecipeDTO.entityToDTO(recipe));
        }
        return recipeDTOS;
    }

}
