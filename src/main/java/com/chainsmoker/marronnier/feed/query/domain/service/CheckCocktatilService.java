package com.chainsmoker.marronnier.feed.query.domain.service;

import com.chainsmoker.marronnier.cocktailrecipe.query.domain.entity.QueryCocktailRecipe;

public interface CheckCocktatilService {
    String findByCocktailId(long cocktailId);
}
