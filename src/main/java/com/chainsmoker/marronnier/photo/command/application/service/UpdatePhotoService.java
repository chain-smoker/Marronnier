package com.chainsmoker.marronnier.photo.command.application.service;


import com.chainsmoker.marronnier.photo.command.application.dto.PhotoDTO;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.Photo;
import com.chainsmoker.marronnier.photo.command.domain.repository.PhotoRepository;
import com.chainsmoker.marronnier.photo.query.application.dto.FindPhotoDTO;
import com.chainsmoker.marronnier.photo.query.application.service.FindPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class UpdatePhotoService {

    private final InsertPhotoService insertPhotoService;
    private final PhotoRepository photoRepository;
    @Autowired
    public UpdatePhotoService(InsertPhotoService insertPhotoService, PhotoRepository photoRepository) {

        this.insertPhotoService = insertPhotoService;
        this.photoRepository = photoRepository;
    }

    @Transactional
    public PhotoDTO updatePhoto(long originId, MultipartFile photo,
                                PhotoCategory photoCategory) throws IOException {

        List<Photo> existPhotoList = photoRepository.findAllByOriginIdAndAndPhotoCategory(originId, photoCategory);
        photoRepository.deleteAll(existPhotoList);

        return insertPhotoService.insertPhoto(originId, photo, photoCategory);
    }
}
