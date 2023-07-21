package com.chainsmoker.marronnier.photo.command.application.service;

import com.chainsmoker.marronnier.photo.command.application.dto.PhotoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/* 통합 테스트 */
@SpringBootTest
class InsertPhotoServiceTest {

    @Autowired
    private InsertPhotoService insertPhotoService;

    private static Stream<Arguments> createPhoto() {

        return Stream.of(
                Arguments.of(
                        1L,
                        "오리지널이름",
                        "변경후이름",
                        "사진구분",
                        "사진위치"
                ),
                Arguments.of(
                        2L,
                        "오리지널이름2",
                        "변경후이름2",
                        "사진구분2",
                        "사진위치2"
                ),
                Arguments.of(
                        3L,
                        "오리지널이름3",
                        "변경후이름3",
                        "사진구분3",
                        "사진위치3"
                )
        );
    }

    @DisplayName("사진 저장하기 테스트")
    @ParameterizedTest
    @MethodSource("createPhoto")
    void testCreateTable(long photoId, String photoName, String photoRename, String photoCategory, String photoRoot) {

        PhotoDTO photoInfo = new PhotoDTO(
                photoId,
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
