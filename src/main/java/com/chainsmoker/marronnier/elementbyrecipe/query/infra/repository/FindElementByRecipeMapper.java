package com.chainsmoker.marronnier.elementbyrecipe.query.infra.repository;

import com.chainsmoker.marronnier.elementbyrecipe.query.application.dto.FindElementByRecipeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FindElementByRecipeMapper {
    List<Long> findElement(Long recipeId);
}
