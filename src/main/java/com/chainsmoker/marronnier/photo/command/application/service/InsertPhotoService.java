package com.chainsmoker.marronnier.photo.command.application.service;

import com.chainsmoker.marronnier.photo.command.application.dto.PhotoDTO;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.Photo;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.vo.OriginVO;
import com.chainsmoker.marronnier.photo.command.domain.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import static com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory.*;

@Service
public class InsertPhotoService {

    private final PhotoRepository photoRepository;
    /* yml 외부 경로 설정 가져오기 */
    @Value("${custom.path.upload-images}")
    private String uploadPath;

    @Autowired
    public InsertPhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Transactional
    public PhotoDTO insertPhoto(long originId,
                                MultipartFile photo,
                                PhotoCategory photoCategory) throws IOException {

        if (photo.isEmpty()) {

            return null;
        }

        // 폴더명 정하는 검증로직
        String savedFolder = null;
        if (photoCategory.equals(COCKTAIL_RECIPE)) {
            savedFolder = "recipe/";
        } else if (photoCategory.equals(ELEMENT)) {
            savedFolder = "element/";
        } else if (photoCategory.equals(FEED)) {
            savedFolder = "feed/";
        }


        File savedFile = null;
        try {
            // 사진 저장 폴더가 없는 경우 생성
            File photoFolder = new File(uploadPath + savedFolder);
            if (!photoFolder.exists()) {
                photoFolder.mkdirs();
            }

            System.out.println("photoFolder = " + photoFolder);

            String originPhotoName = photo.getOriginalFilename();

            if (originPhotoName != null) {

                // 확장자 명으로 분리
                String ext = originPhotoName.substring(originPhotoName.lastIndexOf("."));

                // 저장 될 파일명 변경
                String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

                String savedPath = "/static/upload-images/" + savedFolder + savedName;

                savedFile = new File(photoFolder, savedName);
                photo.transferTo(savedFile);

                PhotoDTO photoInfo = new PhotoDTO(originId, originPhotoName, savedName, photoCategory, savedPath);

                Photo photoEntity = new Photo(
                        photoInfo.getOriginId(),
                        photoInfo.getPhotoCategory(),
                        photoInfo.getPhotoName(),
                        photoInfo.getPhotoRename(),
                        photoInfo.getPhotoRoot()
                );

                photoRepository.save(photoEntity);

                return new PhotoDTO(
                        photoEntity.getId(),
                        photoEntity.getOriginId(),
                        photoEntity.getPhotoName(),
                        photoEntity.getPhotoRename(),
                        photoEntity.getPhotoCategory(),
                        photoEntity.getPhotoRoot());
            }

        } catch (IOException e) {
            Files.delete(savedFile.toPath());
            e.printStackTrace();
        }
        return null;
    }
}
