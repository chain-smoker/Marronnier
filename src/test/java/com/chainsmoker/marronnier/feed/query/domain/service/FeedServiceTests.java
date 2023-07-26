package com.chainsmoker.marronnier.feed.query.domain.service;

import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;
import com.chainsmoker.marronnier.like.query.domain.service.FindLikedFeedService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class FeedServiceTests {

    @Autowired
    private QueryFeedService queryFeedService;

    private static Stream<Arguments> getMemberId() {
        return Stream.of(
                Arguments.of(
                        1
                )
        );
    }
    @DisplayName("memberId로부터 작성한 feed 확인하기")
    @ParameterizedTest
    @MethodSource("getMemberId")
    void checkLikedFeedByMemberIdTests(long memberId){
        List<CheckFeedDTO> testList = queryFeedService.findFeedsByMemberId(memberId);
        testList.forEach(System.out::println);
        Assertions.assertNotNull(testList);
    }

}
