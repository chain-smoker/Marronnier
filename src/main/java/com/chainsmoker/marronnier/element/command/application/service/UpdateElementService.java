package com.chainsmoker.marronnier.element.command.application.service;

import com.chainsmoker.marronnier.cocktailrecipe.command.infra.service.UpdatePictureCocktailRecipeService;
import com.chainsmoker.marronnier.element.command.infra.service.UpdatePictureElementService;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UpdateElementService {

    private UpdatePictureElementService updatePictureElementService;
    @Autowired
    public UpdateElementService(UpdatePictureElementService updatePictureElementService){
        this.updatePictureElementService=updatePictureElementService;
    }
    public void insertPhoto(long originId, MultipartFile photo, PhotoCategory category) throws IOException {
        updatePictureElementService.insertPhoto(originId, photo, category);
    }
}
