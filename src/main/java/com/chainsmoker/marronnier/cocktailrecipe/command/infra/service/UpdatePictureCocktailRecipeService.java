package com.chainsmoker.marronnier.cocktailrecipe.command.infra.service;

import com.chainsmoker.marronnier.cocktailrecipe.command.domain.service.UpdatePictureCocktailRecipe;
import com.chainsmoker.marronnier.common.annotation.InfraService;
import com.chainsmoker.marronnier.photo.command.application.dto.PhotoDTO;
import com.chainsmoker.marronnier.photo.command.application.service.InsertPhotoService;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.query.application.service.FindPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@InfraService
public class UpdatePictureCocktailRecipeService implements UpdatePictureCocktailRecipe {
    private final InsertPhotoService insertPhotoService;

    @Autowired
    public UpdatePictureCocktailRecipeService(InsertPhotoService insertPhotoService){
        this.insertPhotoService=insertPhotoService;
    }

    @Override
    public void insertPhoto(long originId, MultipartFile photo, PhotoCategory photoCategory) throws IOException {
        insertPhotoService.insertPhoto(originId,photo,photoCategory);
    }



}
