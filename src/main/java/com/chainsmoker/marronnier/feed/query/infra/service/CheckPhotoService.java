package com.chainsmoker.marronnier.feed.query.infra.service;

import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.query.application.dto.FindPhotoDTO;
import com.chainsmoker.marronnier.photo.query.application.service.FindPhotoService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckPhotoService implements com.chainsmoker.marronnier.feed.query.domain.service.CheckPhotoService {

    private final FindPhotoService findPhotoService;

    @Autowired
    public CheckPhotoService(FindPhotoService findPhotoService) {
        this.findPhotoService = findPhotoService;
    }

    public List<FindPhotoDTO> findPhotoByIdAndCategory(long feedId, PhotoCategory photoCategory) {
        return findPhotoService.findPhoto(feedId,photoCategory);
    }

}
