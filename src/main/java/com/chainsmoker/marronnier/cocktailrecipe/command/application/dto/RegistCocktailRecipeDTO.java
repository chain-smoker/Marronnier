package com.chainsmoker.marronnier.cocktailrecipe.command.application.dto;

import com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.entity.CocktailRecipeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegistCocktailRecipeDTO {
    private Long id;
    private String name;
    private String description;
    private String classification;
    private String abv;
    private String difficulty;

    public static RegistCocktailRecipeDTO toRegistCocktailRecipeDTO(CocktailRecipeEntity cocktailRecipe){
        RegistCocktailRecipeDTO recipeDTO=new RegistCocktailRecipeDTO();
        recipeDTO.setId(cocktailRecipe.getId());
        recipeDTO.setName(cocktailRecipe.getName());
        recipeDTO.setDescription(cocktailRecipe.getDescription());
        recipeDTO.setClassification(cocktailRecipe.getClassification());
        recipeDTO.setAbv(cocktailRecipe.getAbv());
        recipeDTO.setDifficulty(String.valueOf(cocktailRecipe.getDifficulty()));
        return recipeDTO;
    }
}
