package com.chainsmoker.marronnier.elementbyrecipe.query.application.service;

import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.element.query.application.dto.FindElementDTO;
import com.chainsmoker.marronnier.elementbyrecipe.query.infra.repository.FindElementByRecipeMapper;
import com.chainsmoker.marronnier.elementbyrecipe.query.infra.service.ElementRequestService;
import com.chainsmoker.marronnier.elementbyrecipe.query.infra.service.RecipePictureRequestService;
import com.chainsmoker.marronnier.elementbyrecipe.query.infra.service.RecipeRequestService;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindElementByRecipeService {

    private FindElementByRecipeMapper findElementByRecipeMapper;
    private ElementRequestService elementRequestService;

    private RecipeRequestService cocktailRecipeRequestService;
    private RecipePictureRequestService pictureRequestService;
    @Autowired
    public FindElementByRecipeService(FindElementByRecipeMapper findElementByRecipeMapper,
                                      ElementRequestService elementRequestService,
                                      RecipeRequestService cocktailRecipeRequestService
                                        , RecipePictureRequestService pictureRequestService ){
        this.findElementByRecipeMapper=findElementByRecipeMapper;
        this.elementRequestService=elementRequestService;
        this.cocktailRecipeRequestService=cocktailRecipeRequestService;
        this.pictureRequestService=pictureRequestService;
    }
    public List<FindElementDTO> findElementByRecipe(Long recipeId){
        List<Long> elementIdList = findElementByRecipeMapper.findElement(recipeId);
        List<FindElementDTO> elementList=new ArrayList<>();
        // 수정 이 for문은 사실상 쿼리문에서 해결되는 것인데 Element에서 구현한 메소드를 사용하기 위해 이렇게 써야하는게 맞나?
        for (int i=0; i< elementIdList.size(); i++){
            elementList.add(elementRequestService.findByElementId(elementIdList.get(i)));
        }
        return elementList;
    }

    public FindCocktailRecipeDTO findRecipeById(Long recipeId) {
        FindCocktailRecipeDTO recipeDTO=cocktailRecipeRequestService.findByCocktailRecipeId(recipeId);
        recipeDTO.setImg(
                pictureRequestService.findPictureByCategory(recipeDTO.getId(), PhotoCategory.COCKTAIL_RECIPE).get(0).getPhotoRoot());
        return recipeDTO;
    }
}
