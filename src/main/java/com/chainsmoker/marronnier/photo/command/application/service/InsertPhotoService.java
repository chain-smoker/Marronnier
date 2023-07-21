package com.chainsmoker.marronnier.photo.command.application.service;

import com.chainsmoker.marronnier.photo.command.application.dto.PhotoDTO;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.Photo;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.PhotoCompositeKey;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.vo.OriginVO;
import com.chainsmoker.marronnier.photo.command.domain.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class InsertPhotoService {

    private final PhotoRepository photoRepository;

    @Autowired
    public InsertPhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Transactional
    public PhotoDTO insertPhoto(long originId,
                                MultipartFile photo,
                                PhotoCategory photoCategory) throws IOException {

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
                PhotoDTO photoInfo = new PhotoDTO(originId, originPhotoName, savedName, photoCategory, path);

                Photo photoEntity = new Photo(

                        new PhotoCompositeKey(new OriginVO(photoInfo.getOriginId()), photoInfo.getPhotoCategory()),
                        photoInfo.getPhotoName(),
                        photoInfo.getPhotoRename(),
                        photoInfo.getPhotoRoot()
                );
                photoRepository.save(photoEntity);
                return new PhotoDTO(
                        photoEntity.getPhotoInfo().getOriginId().getId(),
                        photoEntity.getPhotoName(),
                        photoEntity.getPhotoRename(),
                        photoEntity.getPhotoInfo().getPhotoCategory(),
                        photoEntity.getPhotoRoot()
                );
            } catch (IOException e) {
                Files.delete(Path.of(path));
                return null;
            }
        }
        return null;
    }


}
