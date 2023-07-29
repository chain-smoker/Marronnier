package com.chainsmoker.marronnier.photo.command.application.service;


import com.chainsmoker.marronnier.photo.command.application.dto.PhotoDTO;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.query.application.dto.FindPhotoDTO;
import com.chainsmoker.marronnier.photo.query.application.service.FindPhotoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class UpdatePhotoServiceTest {

    @Autowired
    private InsertPhotoService insertPhotoService;

    @Autowired
    private UpdatePhotoService updatePhotoService;

    @Autowired
    private FindPhotoService findPhotoService;

    @Autowired
    ResourceLoader loader;

    @DisplayName("이미지 수정 테스트")
    @Test
    void testPhotoUpdate() throws Exception {

        long originId = 1;
        PhotoCategory category = PhotoCategory.FEED;

        String fileName = "logo.png";
        Resource res = loader.getResource("classpath:/static/images/" + fileName);

        MockMultipartFile file = new MockMultipartFile("file", fileName, null, res.getInputStream());

        insertPhotoService.insertPhoto(originId, file, category);


        String updateFileName = "logo.png";
        Resource updateRes = loader.getResource("classpath:/static/images/" + updateFileName);

        MockMultipartFile updateFile = new MockMultipartFile("file", fileName, null, updateRes.getInputStream());

        updatePhotoService.updatePhoto(originId,updateFile, category);

        List<FindPhotoDTO> findPhotoDTO = findPhotoService.findPhoto(originId, category);

        Assertions.assertEquals(findPhotoDTO.get(0).getPhotoName(), updateFileName);
    }
}


