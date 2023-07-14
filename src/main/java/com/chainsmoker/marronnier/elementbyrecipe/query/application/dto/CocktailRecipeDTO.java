package com.chainsmoker.marronnier.elementbyrecipe.query.application.dto;

import com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.EnumType.DifficultyEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class CocktailRecipeDTO {
    private Long id;
    private String name;
    private String description;
    private String classification;
    private String abv;
    private DifficultyEnum difficulty;

}