package com.chainsmoker.marronnier.cocktailrecipe.query.application.service;

import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.query.domain.entity.QueryCocktailRecipe;
import com.chainsmoker.marronnier.cocktailrecipe.query.infra.repository.SearchCocktailRecipeMapper;
import com.chainsmoker.marronnier.cocktailrecipe.query.infra.service.CocktailRecipePictureRequestService;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchCocktailRecipeService {
    private final SearchCocktailRecipeMapper searchCocktailRecipeMapper;

    private final CocktailRecipePictureRequestService pictureRequestService;

    @Autowired
    public SearchCocktailRecipeService(SearchCocktailRecipeMapper searchCocktailRecipeMapper,
                                       CocktailRecipePictureRequestService pictureRequestService){
        this.pictureRequestService=pictureRequestService;
        this.searchCocktailRecipeMapper=searchCocktailRecipeMapper;
    }

    public List<FindCocktailRecipeDTO> searchCocktailRecipe(String searchWord){
        List<QueryCocktailRecipe> recipes=searchCocktailRecipeMapper.searchCocktailRecipe(searchWord);
        List<FindCocktailRecipeDTO> recipeDTOS=new ArrayList<>();
        for (QueryCocktailRecipe recipe:recipes){
            recipeDTOS.add(FindCocktailRecipeDTO.entityToDTO(recipe));
        }
        int recipeSize=recipeDTOS.size();
        for (int i=0; i<recipeSize; i++){
            recipeDTOS.get(i).setImg(
                    pictureRequestService.findPictureByCategory(recipeDTOS.get(i).getId(), PhotoCategory.COCKTAIL_RECIPE).get(0).getPhotoRoot()
            );
        }
        return recipeDTOS;
    }

}
