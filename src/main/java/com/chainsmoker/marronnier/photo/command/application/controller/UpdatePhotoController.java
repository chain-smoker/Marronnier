package com.chainsmoker.marronnier.photo.command.application.controller;


import com.chainsmoker.marronnier.photo.command.application.service.UpdatePhotoService;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/photo")
public class UpdatePhotoController {

    private final UpdatePhotoService updatePhotoService;

    @Autowired
    public UpdatePhotoController(UpdatePhotoService updatePhotoService) {
        this.updatePhotoService = updatePhotoService;
    }

    @PostMapping("update")
    public String updatePhoto(@RequestParam MultipartFile photo,
                              @RequestParam PhotoCategory category,
                              @RequestParam(defaultValue = "1") long originId) throws IOException {

        updatePhotoService.updatePhoto(originId, photo, category);

        return "redirect:/home";
    }
}
