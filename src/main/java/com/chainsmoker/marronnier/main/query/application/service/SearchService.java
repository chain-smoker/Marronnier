package com.chainsmoker.marronnier.main.query.application.service;

import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.cocktailrecipe.query.infra.service.CocktailRecipePictureRequestService;
import com.chainsmoker.marronnier.element.query.application.dto.FindElementDTO;
import com.chainsmoker.marronnier.main.query.infra.service.CocktailRecipeQueryRequestService;
import com.chainsmoker.marronnier.main.query.infra.service.ElementQueryRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private final ElementQueryRequestService elementQueryRequestService;
    private final CocktailRecipeQueryRequestService cocktailRecipeQueryRequestService;
    @Autowired
    public SearchService(ElementQueryRequestService elementQueryRequestService,
                         CocktailRecipeQueryRequestService cocktailRecipeQueryRequestService){
        this.elementQueryRequestService=elementQueryRequestService;
        this.cocktailRecipeQueryRequestService=cocktailRecipeQueryRequestService;
    }

    public List<FindElementDTO> searchElement(String searchWord){
        return elementQueryRequestService.searchElement(searchWord);
    }

    public List<FindCocktailRecipeDTO> searchCocktailRecipe(String searchWord){
        return cocktailRecipeQueryRequestService.searchCocktailRecipe(searchWord);
    }
}
