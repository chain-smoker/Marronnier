package com.chainsmoker.marronnier.cocktailrecipe.command.application.service;

import com.chainsmoker.marronnier.cocktailrecipe.command.infra.service.UpdatePictureCocktailRecipeService;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UpdateCocktailRecipeService {

    private UpdatePictureCocktailRecipeService updatePictureCocktailRecipeService;

    @Autowired
    public UpdateCocktailRecipeService(UpdatePictureCocktailRecipeService updatePictureCocktailRecipeService){
        this.updatePictureCocktailRecipeService=updatePictureCocktailRecipeService;
    }
    public void insertPhoto(long originId, MultipartFile photo, PhotoCategory category) throws IOException {
        updatePictureCocktailRecipeService.insertPhoto(originId,photo,category);

    }
}
