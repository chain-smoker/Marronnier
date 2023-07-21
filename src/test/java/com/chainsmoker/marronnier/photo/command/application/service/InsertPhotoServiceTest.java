package com.chainsmoker.marronnier.photo.command.application.service;

import com.chainsmoker.marronnier.photo.command.application.dto.PhotoDTO;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Stream;

import static com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory.*;

/* 통합 테스트 */
@SpringBootTest
@Transactional
class InsertPhotoServiceTest {

    @Autowired
    private InsertPhotoService insertPhotoService;

    private static Stream<Arguments> createPhoto() {

        return Stream.of(
                Arguments.of(
                        1L,
                        "오리지널이름.png",
                        "변경후이름.png",
                        COCKTAIL_RECIPE,
                        "src/photo/오리지널이름"
                ),
                Arguments.of(
                        2L,
                        "오리지널이름2.png",
                        "변경후이름2.png",
                        ELEMENT,
                        "src/photo/오리지널이름2"
                ),
                Arguments.of(
                        3L,
                        "오리지널이름3.png",
                        "변경후이름3.png",
                        FEED,
                        "src/photo/오리지널이름3"
                )
        );
    }

    @DisplayName("사진 저장하기 테스트")
    @ParameterizedTest
    @MethodSource("createPhoto")
    void testCreateTable(long originId, String photoName, String photoRename, PhotoCategory photoCategory, String photoRoot) throws IOException {

        PhotoDTO photoInfo = new PhotoDTO(
                originId,
                photoName,
                photoRename,
                photoCategory,
                photoRoot
        );

        String root = new File("src/main/resources/static").getAbsolutePath();

        String photoPath = root + "/photo/08b16de6dd9340f3bd7f23c0854f7b8e.png";
        File dir = new File(photoPath);

        MultipartFile photo = new MockMultipartFile("image",photoName, "image/png", new FileInputStream(dir));

        PhotoDTO result = insertPhotoService.insertPhoto(originId,photo,photoCategory);

        Assertions.assertNotNull(result);
    }
}
