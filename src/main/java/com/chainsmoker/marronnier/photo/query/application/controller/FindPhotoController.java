package com.chainsmoker.marronnier.photo.query.application.controller;

import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.query.application.dto.FindPhotoDTO;
import com.chainsmoker.marronnier.photo.query.application.service.FindPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/photo/*")
public class FindPhotoController {

    private final FindPhotoService findPhotoService;

    @Autowired
    public FindPhotoController(FindPhotoService findPhotoService) {

        this.findPhotoService = findPhotoService;
    }

    @GetMapping("result")
    public String findPhoto(Model model) {

        long id = 1L;
        PhotoCategory photoCategory = PhotoCategory.FEED;

        List<FindPhotoDTO> photos = findPhotoService.findPhoto(id, photoCategory);

        model.addAttribute("photos", photos);

        return "photo/result";
    }

}
