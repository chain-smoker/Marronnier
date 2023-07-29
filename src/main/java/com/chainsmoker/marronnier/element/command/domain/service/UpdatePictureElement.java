package com.chainsmoker.marronnier.element.command.domain.service;

import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UpdatePictureElement {
    public void insertPhoto(long originId, MultipartFile photo, PhotoCategory photoCategory) throws IOException;
}
