package com.chainsmoker.marronnier.cocktailrecipe.query.application.service;

import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.query.domain.entity.QueryCocktailRecipe;
import com.chainsmoker.marronnier.cocktailrecipe.query.infra.repository.RecommandMapper;
import com.chainsmoker.marronnier.cocktailrecipe.query.infra.service.PictureRequestService;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RecommandService {

    private final RecommandMapper recommandMapper;
    private final PictureRequestService pictureRequestService;

    @Autowired
    public RecommandService(RecommandMapper recommandMapper, PictureRequestService pictureRequestService){
        this.recommandMapper=recommandMapper;
        this.pictureRequestService=pictureRequestService;
    }

    public List<FindCocktailRecipeDTO> recommandCocktail(Map<String, String> recommandInfo){
        List<QueryCocktailRecipe> recipes=recommandMapper.findRecommandCocktail(recommandInfo);
        List<FindCocktailRecipeDTO> recipeDTOS=new ArrayList<>();
        for (QueryCocktailRecipe recipe:recipes){
            recipeDTOS.add(FindCocktailRecipeDTO.entityToDTO(recipe));
        }
        // 사진 등록
        int recipeSize= recipeDTOS.size();
        for (int i=0; i<recipeSize; i++){
            recipeDTOS.get(i).setImg(
                    pictureRequestService.findPictureByCategory(recipeDTOS.get(i).getId(), PhotoCategory.COCKTAIL_RECIPE).get(0).getPhotoRoot());
        }
        return recipeDTOS;
    }

}
