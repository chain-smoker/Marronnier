package com.chainsmoker.marronnier.cocktailrecipe.command.application.dto;

import com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.EnumType.DifficultyEnum;
import com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.entity.CocktailRecipe;
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
    private String recipe;
    private DifficultyEnum difficulty;

    // 삭제 static이 필요한가???
    public static RegistCocktailRecipeDTO toRegistCocktailRecipeDTO(CocktailRecipe cocktailRecipe){
        RegistCocktailRecipeDTO recipeDTO=new RegistCocktailRecipeDTO();
        recipeDTO.setId(cocktailRecipe.getId());
        recipeDTO.setName(cocktailRecipe.getName());
        recipeDTO.setDescription(cocktailRecipe.getDescription());
        recipeDTO.setClassification(cocktailRecipe.getClassification());
        recipeDTO.setAbv(cocktailRecipe.getAbv());
        recipeDTO.setRecipe(cocktailRecipe.getRecipe());
        recipeDTO.setDifficulty(cocktailRecipe.getDifficulty());
        return recipeDTO;
    }

    @Override
    public String toString() {
        return "RegistCocktailRecipeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", classification='" + classification + '\'' +
                ", abv='" + abv + '\'' +
                ", recipe='" + recipe + '\'' +
                ", difficulty=" + difficulty +
                '}';
    }
}
