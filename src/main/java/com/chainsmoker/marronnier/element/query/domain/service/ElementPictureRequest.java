package com.chainsmoker.marronnier.element.query.domain.service;

import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.query.application.dto.FindPhotoDTO;

import java.util.List;

public interface ElementPictureRequest {
    public List<FindPhotoDTO> findPictureByCategory(long originId, PhotoCategory category);
}
