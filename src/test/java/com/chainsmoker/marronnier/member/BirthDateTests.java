package com.chainsmoker.marronnier.member;

import com.chainsmoker.marronnier.member.command.application.dto.UpdateMemberDTO;
import com.chainsmoker.marronnier.member.command.application.service.UpdateMemberService;
import com.chainsmoker.marronnier.member.command.domain.aggregate.vo.BirthDateVO;
import com.chainsmoker.marronnier.member.command.domain.exception.BirthDateAfterException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.stream.Stream;

@SpringBootTest
@Transactional
public class BirthDateTests {

    @Autowired
    private UpdateMemberService updateMemberService;

    private static Stream<Arguments> getBirthDate() {
        return Stream.of(
                Arguments.of(
                        "2023-08-31"
                ),
                Arguments.of(
                        "2024-01-01"
                )
        );
    }

    @DisplayName("오늘 이후 생년월일 입력 시 BirthDateAfterException 발생하는지 확인")
    @ParameterizedTest
    @MethodSource("getBirthDate")
    void testBirthDateExceptionTests(String date) {

        Assertions.assertThrows(BirthDateAfterException.class, () -> {
            new BirthDateVO(LocalDate.parse(date));
        });
    }

}
