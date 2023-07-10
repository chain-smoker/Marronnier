package com.chainsmoker.marronnier.cocktailrecipe.command.domain.repository;

import com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.entity.CocktailRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocktailRecipeRepository extends JpaRepository<CocktailRecipe,Long> {
}
