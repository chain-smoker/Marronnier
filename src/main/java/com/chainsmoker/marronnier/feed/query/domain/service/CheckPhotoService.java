package com.chainsmoker.marronnier.feed.query.domain.service;

import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.query.application.dto.FindPhotoDTO;

import java.util.List;

public interface CheckPhotoService {
    List<FindPhotoDTO> findPhotoByIdAndCategory(long feedId, PhotoCategory photoCategory);
}
