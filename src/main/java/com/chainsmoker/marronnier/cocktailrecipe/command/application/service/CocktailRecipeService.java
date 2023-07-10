package com.chainsmoker.marronnier.cocktailrecipe.command.application.service;

import com.chainsmoker.marronnier.cocktailrecipe.command.application.dto.RegistCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.EnumType.DifficultyEnum;
import com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.entity.CocktailRecipe;
import com.chainsmoker.marronnier.cocktailrecipe.command.domain.repository.CocktailRecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CocktailRecipeService {
    private final CocktailRecipeRepository cocktailRecipeRepository;

    public void regist(RegistCocktailRecipeDTO recipeDTO){
        CocktailRecipe cocktailRecipe= CocktailRecipe.builder().name(recipeDTO.getName())
                .description(recipeDTO.getDescription()).classification(recipeDTO.getClassification())
                .abv(recipeDTO.getAbv()).difficulty(DifficultyEnum.valueOf(recipeDTO.getDifficulty())).build();
        cocktailRecipeRepository.save(cocktailRecipe);
    }
}
