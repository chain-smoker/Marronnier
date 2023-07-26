package com.chainsmoker.marronnier.photo.query.application.service;

import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.query.application.dto.FindPhotoDTO;
import com.chainsmoker.marronnier.photo.query.domain.repository.PhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FindPhotoService {

    private final PhotoMapper photoMapper;

    @Autowired
    public FindPhotoService(PhotoMapper photoMapper) {

        this.photoMapper = photoMapper;
    }
    public List<FindPhotoDTO> findPhoto(long originId, PhotoCategory category) {

        Map<String, Object> photoMap = new HashMap<>();
        photoMap.put("originId", originId);
        photoMap.put("category", category);

        return photoMapper.findByIdAndCategoryPhotos(photoMap);
    }
}
