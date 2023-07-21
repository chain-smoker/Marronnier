package com.chainsmoker.marronnier.photo.command.application.service;

import com.chainsmoker.marronnier.photo.command.application.dto.PhotoDTO;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.Photo;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.PhotoCompositeKey;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.vo.OriginVO;
import com.chainsmoker.marronnier.photo.command.domain.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InsertPhotoService {

    private final PhotoRepository photoRepository;

    @Autowired
    public InsertPhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Transactional
    public void insertPhoto(PhotoDTO photoInfo) {



        Photo photo = new Photo(

                new PhotoCompositeKey(new OriginVO(photoInfo.getOriginId()), photoInfo.getPhotoCategory()),
                photoInfo.getPhotoName(),
                photoInfo.getPhotoRename(),
                photoInfo.getPhotoRoot()
        );
        photoRepository.save(photo);
    }
}
