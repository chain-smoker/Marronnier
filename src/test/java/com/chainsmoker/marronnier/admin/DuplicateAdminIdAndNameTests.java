package com.chainsmoker.marronnier.admin;


import com.chainsmoker.marronnier.admin.command.application.dto.CreateAdminDTO;
import com.chainsmoker.marronnier.admin.command.application.service.RegistAdminService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@SpringBootTest
@Transactional
public class DuplicateAdminIdAndNameTests {

    @Autowired
    private RegistAdminService registAdminService;


    private static Stream<Arguments> getAdmin() {
        return Stream.of(
                Arguments.of(
                        "adminIdTest",
                        "adminNameTest"
                ),
                Arguments.of(
                        "adminIdTest2",
                        "adminNameTest2"
                )
        );
    }

    @DisplayName("중복된 관리자 아이디 및 이름 예외 처리 확인 테스트")
    @ParameterizedTest
    @MethodSource("getAdmin")
    void testDuplicateAdminIdAndNameTests(String adminId, String adminName) {

        CreateAdminDTO createAdminDTO = new CreateAdminDTO(adminId, "1234", adminName);
        registAdminService.create(createAdminDTO);

        Assertions.assertThrows(DataIntegrityViolationException.class,
                () -> registAdminService.create(createAdminDTO)
        );
    }

}
