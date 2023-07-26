package com.chainsmoker.marronnier.photo.query.domain.repository;

import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.query.application.dto.FindPhotoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PhotoMapper {
    List<FindPhotoDTO> findByIdAndCategoryPhotos(long originId, PhotoCategory category);

    List<FindPhotoDTO> findByIdAndCategoryPhotos(Map<String, Object> photoMap);
}
