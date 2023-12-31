package com.chainsmoker.marronnier.cocktailrecipe.query.application.dto;

import com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.EnumType.DifficultyEnum;
import com.chainsmoker.marronnier.cocktailrecipe.query.domain.entity.QueryCocktailRecipe;
import com.chainsmoker.marronnier.photo.command.application.dto.PhotoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
public class FindCocktailRecipeDTO {
    private Long id;
    private String name;
    private String description;
    private String classification;
    private String abv;
    private String recipe;
    private String difficulty;
    private String img;

    public static FindCocktailRecipeDTO entityToDTO(QueryCocktailRecipe queryCocktailRecipe){
        FindCocktailRecipeDTO recipeDTO=new FindCocktailRecipeDTO();
        recipeDTO.setId(queryCocktailRecipe.getId());
        recipeDTO.setName(queryCocktailRecipe.getName());
        recipeDTO.setDescription(queryCocktailRecipe.getDescription());
        recipeDTO.setClassification(queryCocktailRecipe.getClassification());
        recipeDTO.setAbv(queryCocktailRecipe.getAbv());
        recipeDTO.setRecipe(queryCocktailRecipe.getRecipe());
        recipeDTO.setDifficulty(String.valueOf(queryCocktailRecipe.getDifficulty()));
        return recipeDTO;
    }

    @Override
    public String toString() {
        return "FindCocktailRecipeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", classification='" + classification + '\'' +
                ", abv='" + abv + '\'' +
                ", recipe='" + recipe + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
