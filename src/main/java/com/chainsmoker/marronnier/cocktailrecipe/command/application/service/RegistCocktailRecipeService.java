package com.chainsmoker.marronnier.cocktailrecipe.command.application.service;

import com.chainsmoker.marronnier.cocktailrecipe.command.application.dto.RegistCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.EnumType.DifficultyEnum;
import com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.entity.CocktailRecipeEntity;
import com.chainsmoker.marronnier.cocktailrecipe.command.domain.repository.CocktailRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistCocktailRecipeService {
    private final CocktailRecipeRepository cocktailRecipeRepository;
    @Autowired
    public RegistCocktailRecipeService(CocktailRecipeRepository cocktailRecipeRepository){
        this.cocktailRecipeRepository=cocktailRecipeRepository;
    }

    public void regist(RegistCocktailRecipeDTO recipeDTO){
        CocktailRecipeEntity cocktailRecipe= CocktailRecipeEntity.builder().name(recipeDTO.getName())
                .description(recipeDTO.getDescription()).classification(recipeDTO.getClassification())
                .abv(recipeDTO.getAbv()).difficulty(DifficultyEnum.valueOf(recipeDTO.getDifficulty())).build();
        cocktailRecipeRepository.save(cocktailRecipe);
    }
}
