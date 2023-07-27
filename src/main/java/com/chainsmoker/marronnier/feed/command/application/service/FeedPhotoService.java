package com.chainsmoker.marronnier.feed.command.application.service;

import com.chainsmoker.marronnier.feed.command.domain.service.InsertPhotoToFeedService;
import com.chainsmoker.marronnier.photo.command.application.dto.PhotoDTO;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FeedPhotoService
{
    private final InsertPhotoToFeedService insertPhotoToFeedService;

    @Autowired
    public FeedPhotoService(InsertPhotoToFeedService insertPhotoToFeedService) {
        this.insertPhotoToFeedService = insertPhotoToFeedService;
    }

    public PhotoDTO savePhoto(long feedId,
                              MultipartFile photo,
                              PhotoCategory photoCategory) throws IOException {
        return insertPhotoToFeedService.savePhoto(feedId,photo,photoCategory);
    }
}
