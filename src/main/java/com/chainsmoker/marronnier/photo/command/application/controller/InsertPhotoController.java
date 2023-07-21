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
@RequestMapping("/photo/*")
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
                           @RequestParam(defaultValue = "1") long id) throws IOException {

        /* 파일 저장 static 경로 가져옴 */
        String root = new File("src/main/resources/static").getAbsolutePath();

        String photoPath = root + "/photo";

        /* 파일 저장 객체 생성 */
        File dir = new File(photoPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String originPhotoName = photo.getOriginalFilename();
        if (originPhotoName != null) {

            /* 확장자 명으로 분리 */
            String ext = originPhotoName.substring(originPhotoName.lastIndexOf("."));

            String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

            String path = "/photo" + "/" + savedName;
            try {
                photo.transferTo(new File(photoPath + "/" + savedName));
                PhotoDTO photoinfo = new PhotoDTO(id, originPhotoName, savedName, category, path);

                insertPhotoService.insertPhoto(photoinfo);

            } catch (IOException e) {
                Files.delete(Path.of(path));
            }
        }

        return "redirect:/home";
    }

}
