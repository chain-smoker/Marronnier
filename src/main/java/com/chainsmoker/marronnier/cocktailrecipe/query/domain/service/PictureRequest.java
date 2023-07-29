package com.chainsmoker.marronnier.cocktailrecipe.query.domain.service;

import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.query.application.dto.FindPhotoDTO;

import java.util.List;

public interface PictureRequest {
    public List<FindPhotoDTO> findPictureByCategory(long originId, PhotoCategory category);
}
