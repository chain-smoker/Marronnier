package com.chainsmoker.marronnier.cocktailrecipe.query.infra.repository;

import com.chainsmoker.marronnier.cocktailrecipe.query.domain.entity.QueryCocktailRecipe;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FindCocktailMapper {
    List<QueryCocktailRecipe> findAll();
}
