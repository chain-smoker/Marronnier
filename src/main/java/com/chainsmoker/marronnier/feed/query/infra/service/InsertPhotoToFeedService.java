package com.chainsmoker.marronnier.feed.query.infra.service;

import com.chainsmoker.marronnier.photo.command.application.dto.PhotoDTO;
import com.chainsmoker.marronnier.photo.command.application.service.InsertPhotoService;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class InsertPhotoToFeedService implements com.chainsmoker.marronnier.feed.command.domain.service.InsertPhotoToFeedService {
    private final InsertPhotoService insertPhotoService;
    @Autowired
    public InsertPhotoToFeedService(InsertPhotoService insertPhotoService) {
        this.insertPhotoService = insertPhotoService;
    }

    public PhotoDTO savePhoto(long feedId,
                              MultipartFile photo,
                              PhotoCategory photoCategory) throws IOException {
        return insertPhotoService.insertPhoto(feedId,photo,photoCategory);
    }
}
