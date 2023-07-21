package com.chainsmoker.marronnier.photo.command.application.service;

import com.chainsmoker.marronnier.photo.command.application.dto.PhotoDTO;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.PhotoCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.PhotoCategory.*;
import static org.junit.jupiter.api.Assertions.*;

/* 통합 테스트 */
@SpringBootTest
class InsertPhotoServiceTest {

    @Autowired
    private InsertPhotoService insertPhotoService;

    private static Stream<Arguments> createPhoto() {

        return Stream.of(
                Arguments.of(
                        "오리지널이름",
                        "변경후이름",
                        COCKTAIL_RECIPE,
                        "사진위치"
                ),
                Arguments.of(
                        "오리지널이름2",
                        "변경후이름2",
                        ELEMENT,
                        "사진위치2"
                ),
                Arguments.of(
                        "오리지널이름3",
                        "변경후이름3",
                        FEED,
                        "사진위치3"
                )
        );
    }

    @DisplayName("사진 저장하기 테스트")
    @ParameterizedTest
    @MethodSource("createPhoto")
    void testCreateTable(String photoName, String photoRename, PhotoCategory photoCategory, String photoRoot) {

        PhotoDTO photoInfo = new PhotoDTO(
                photoName,
                photoRename,
                photoCategory,
                photoRoot
        );

        Assertions.assertDoesNotThrow(
                () -> insertPhotoService.insertPhoto(photoInfo)
        );
    }
}
