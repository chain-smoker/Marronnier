package com.chainsmoker.marronnier;


import com.chainsmoker.marronnier.basket.command.application.dto.CreateBasketDTO;
import com.chainsmoker.marronnier.basket.command.application.service.RegistBasketService;
import com.chainsmoker.marronnier.basket.query.application.dto.MemberCockTailBasketDTO;
import com.chainsmoker.marronnier.basket.query.application.service.FindBasketService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
@Transactional
public class CompositeKeyBasketTests {

    @Autowired
    private RegistBasketService registBasketService;

    @Autowired
    private FindBasketService findBasketService;

    private static Stream<Arguments> getBasket() {
        return Stream.of(
                Arguments.of(
                        1,
                        11
                ),
                Arguments.of(
                        1,
                        11
                )
        );
    }

    @DisplayName("복합키를 통한 술바구니 생성 여부 확인")
    @ParameterizedTest
    @MethodSource("getBasket")
    void testCompositeKeyDuplicateTests(long memberId, long cocktailRecipeId) {

        CreateBasketDTO createBasketDTO = new CreateBasketDTO(memberId, cocktailRecipeId);

        registBasketService.create(createBasketDTO);

        Assertions.assertDoesNotThrow(
                () -> registBasketService.create(createBasketDTO)
        );
    }

}
