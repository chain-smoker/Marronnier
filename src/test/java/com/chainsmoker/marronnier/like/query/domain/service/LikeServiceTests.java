package com.chainsmoker.marronnier.like.query.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class LikeServiceTests {
    @Autowired
    private FindLikeService findLikeService;

    private static Stream<Arguments> getMemberId() {
        return Stream.of(
                Arguments.of(
                        1
                )
        );
    }

    @DisplayName("memberId로부터 좋아요 누른 feed 확인하기")
    @ParameterizedTest
    @MethodSource("getMemberId")
    void checkLikedFeedByMemberIdTests(long memberId){
        List<Long> testList = findLikeService.findLikedFeedByMemberId(memberId);
        testList.forEach(System.out::println);
        Assertions.assertNotNull(testList);
    }

}
