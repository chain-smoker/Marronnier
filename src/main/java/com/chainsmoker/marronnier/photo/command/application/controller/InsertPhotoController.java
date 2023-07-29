package com.chainsmoker.marronnier.photo.command.application.controller;

import com.chainsmoker.marronnier.photo.command.application.dto.PhotoDTO;
import com.chainsmoker.marronnier.photo.command.application.service.InsertPhotoService;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Controller
@RequestMapping("/photo")
public class InsertPhotoController {

    private final InsertPhotoService insertPhotoService;

    @Autowired
    public InsertPhotoController(InsertPhotoService insertPhotoService) {

        this.insertPhotoService = insertPhotoService;
    }

    @GetMapping("")
    public String photo() {

        return "photo/write";
    }

    @PostMapping("add")
    public String addPhoto(@RequestParam MultipartFile photo,
                           @RequestParam PhotoCategory category,
                           @RequestParam(defaultValue = "1") long originId) throws IOException {


        insertPhotoService.insertPhoto(originId, photo, category);

            return "redirect:/home";
        }
}
