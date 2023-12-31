package com.chainsmoker.marronnier.cocktailrecipe.command.application.service;

import com.chainsmoker.marronnier.cocktailrecipe.command.application.dto.RegistCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.EnumType.DifficultyEnum;
import com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.entity.CocktailRecipe;
import com.chainsmoker.marronnier.cocktailrecipe.command.domain.repository.CocktailRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistCocktailRecipeService {
    private final CocktailRecipeRepository cocktailRecipeRepository;
    @Autowired
    public RegistCocktailRecipeService(CocktailRecipeRepository cocktailRecipeRepository){
        this.cocktailRecipeRepository=cocktailRecipeRepository;
    }

    public CocktailRecipe regist(RegistCocktailRecipeDTO recipeDTO){
        CocktailRecipe cocktailRecipe =
                new CocktailRecipe(recipeDTO.getName(),
                        recipeDTO.getDescription(),
                        recipeDTO.getClassification(),
                        recipeDTO.getAbv(),
                        recipeDTO.getRecipe(),
                        recipeDTO.getDifficulty()
                );
        return cocktailRecipeRepository.save(cocktailRecipe);
    }
}
