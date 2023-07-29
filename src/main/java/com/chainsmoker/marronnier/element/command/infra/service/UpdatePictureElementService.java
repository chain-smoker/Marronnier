package com.chainsmoker.marronnier.element.command.infra.service;

import com.chainsmoker.marronnier.cocktailrecipe.command.domain.service.UpdatePictureCocktailRecipe;
import com.chainsmoker.marronnier.common.annotation.InfraService;
import com.chainsmoker.marronnier.element.command.domain.service.UpdatePictureElement;
import com.chainsmoker.marronnier.photo.command.application.service.InsertPhotoService;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@InfraService
public class UpdatePictureElementService implements UpdatePictureElement {
    private final InsertPhotoService insertPhotoService;

    @Autowired
    public UpdatePictureElementService(InsertPhotoService insertPhotoService){
        this.insertPhotoService=insertPhotoService;
    }

    @Override
    public void insertPhoto(long originId, MultipartFile photo, PhotoCategory photoCategory) throws IOException {
        insertPhotoService.insertPhoto(originId,photo,photoCategory);
    }

}
