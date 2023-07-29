package com.chainsmoker.marronnier.cocktailrecipe.query.infra.service;

import com.chainsmoker.marronnier.cocktailrecipe.query.domain.service.PictureRequest;
import com.chainsmoker.marronnier.common.annotation.InfraService;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.query.application.dto.FindPhotoDTO;
import com.chainsmoker.marronnier.photo.query.application.service.FindPhotoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@InfraService
public class PictureRequestService implements PictureRequest {

    private FindPhotoService findPhotoService;

    @Autowired
    public PictureRequestService(FindPhotoService findPhotoService){
        this.findPhotoService=findPhotoService;
    }
    @Override
    public List<FindPhotoDTO> findPictureByCategory(long originId, PhotoCategory category){
        return findPhotoService.findPhoto(originId,category);
    }
}
