package com.chainsmoker.marronnier.cocktailrecipe.query.infra.repository;

import com.chainsmoker.marronnier.cocktailrecipe.query.domain.entity.QueryCocktailRecipe;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecommandMapper {
    List<QueryCocktailRecipe> findRecommandCocktail(Map<String, String> recommandInfo);
}
