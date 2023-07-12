package com.chainsmoker.marronnier.cocktailrecipe.command.application.service;

import com.chainsmoker.marronnier.cocktailrecipe.command.application.dto.RegistCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.EnumType.DifficultyEnum;
import com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.entity.CocktailRecipe;
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
        CocktailRecipe cocktailRecipe =
                new CocktailRecipe(recipeDTO.getName(),
                        recipeDTO.getDescription(),
                        recipeDTO.getClassification(),
                        recipeDTO.getAbv(),
                        recipeDTO.getDifficulty()
                );
        cocktailRecipeRepository.save(cocktailRecipe);
    }
}
