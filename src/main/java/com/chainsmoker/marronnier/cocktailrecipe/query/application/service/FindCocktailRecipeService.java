package com.chainsmoker.marronnier.cocktailrecipe.query.application.service;

import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.query.domain.entity.QueryCocktailRecipe;
import com.chainsmoker.marronnier.cocktailrecipe.query.infra.repository.FindCocktailRecipeMapper;
import com.chainsmoker.marronnier.cocktailrecipe.query.infra.service.CocktailRecipePictureRequestService;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindCocktailRecipeService {
    private final FindCocktailRecipeMapper findCocktailMapper;

    private final CocktailRecipePictureRequestService pictureRequestService;

    @Autowired
    public FindCocktailRecipeService(FindCocktailRecipeMapper findCocktailMapper,
                                     CocktailRecipePictureRequestService pictureRequestService){
        this.findCocktailMapper=findCocktailMapper;
        this.pictureRequestService=pictureRequestService;
    }

    public List<FindCocktailRecipeDTO> findAllCocktailRecipe(){
        List<QueryCocktailRecipe> recipes=findCocktailMapper.findAll();
        List<FindCocktailRecipeDTO> recipeDTOS=new ArrayList<>();
        for (QueryCocktailRecipe recipe:recipes ){
            recipeDTOS.add(FindCocktailRecipeDTO.entityToDTO(recipe));
        }
        return recipeDTOS;
    }
    public FindCocktailRecipeDTO findByCocktailRecipeId(Long cocktailrecipeId){
        QueryCocktailRecipe recipe=findCocktailMapper.findById(cocktailrecipeId);
        System.out.println("QueryCocktailRecipe = " + recipe);
        FindCocktailRecipeDTO recipeDTO=FindCocktailRecipeDTO.entityToDTO(recipe);
        recipeDTO.setImg(pictureRequestService.findPictureByCategory(recipeDTO.getId(), PhotoCategory.COCKTAIL_RECIPE).get(0).getPhotoRoot());
        return recipeDTO;
    }
}
