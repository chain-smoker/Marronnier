package com.chainsmoker.marronnier.basket;


import com.chainsmoker.marronnier.basket.query.application.service.FindBasketService;
import com.chainsmoker.marronnier.member.query.application.dto.FindBasketsPaginationDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@SpringBootTest
@Transactional
public class PaginationBasketTests {

    @Autowired
    private FindBasketService findBasketService;

    private static Stream<Arguments> getBasketsByPagination() {
        return Stream.of(
                Arguments.of(
                        1,
                        1
                ),
                Arguments.of(
                        1,
                        2
                )
        );
    }

    @ParameterizedTest(name = "페이지 번호를 통해 사용자의 술바구니 목록 페이징 조회 | 사용자 Id : {0} , 페이지 번호 : {1}")
    @MethodSource("getBasketsByPagination")
    void testCompositeKeyDuplicateTests(long memberId, int page) {

        FindBasketsPaginationDTO result = findBasketService.findAllByMemberIdPagination(memberId, page);
        Assertions.assertNotNull(result.getBaskets());
    }

}
