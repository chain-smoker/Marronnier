package com.chainsmoker.marronnier.feed.command.controller.service;

import com.chainsmoker.marronnier.feed.command.application.dto.CreateFeedDTO;
import com.chainsmoker.marronnier.feed.command.application.dto.UpdateFeedDTO;
import com.chainsmoker.marronnier.feed.command.application.service.FeedDeleteService;
import com.chainsmoker.marronnier.feed.command.application.service.FeedInsertService;
import com.chainsmoker.marronnier.feed.command.application.service.FeedPhotoService;
import com.chainsmoker.marronnier.feed.command.application.service.FeedUpdateService;
import com.chainsmoker.marronnier.feed.command.domain.aggregate.VO.MemberVO;
import com.chainsmoker.marronnier.feed.command.domain.aggregate.entity.Feed;
import com.chainsmoker.marronnier.feed.query.application.service.FindFeedService;
import com.chainsmoker.marronnier.feed.query.domain.service.QueryFeedService;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@SpringBootTest
@Transactional
public class FeedApplicationServiceTests {
    @Autowired
    private FeedDeleteService feedDeleteService;
    @Autowired
    private FeedInsertService feedInsertService;
    @Autowired
    private FeedUpdateService feedUpdateService;
    @Autowired
    private FindFeedService findFeedService;


    private static Stream<Arguments> Feed() {
        return Stream.of(
                Arguments.of(
                        1,
                        1,
                        1,
                        "안녕"
                )
        );
    }

    private static Stream<Arguments> UpdateFeed() {
        return Stream.of(
                Arguments.of(
                        1,
                        1,
                        1,
                        "안녕하세요"
                )
        );
    }

    @DisplayName("피드 생성 여부 확인")
    @ParameterizedTest
    @MethodSource("Feed")
    void feedInsertTest(long feedId , long memberId, long cocktailId, String contents){
        CreateFeedDTO feed = new CreateFeedDTO();
        feed.setCocktailId(cocktailId);
        feed.setContent(contents);
        feed.setMemberId(memberId);

        long id = feedInsertService.saveFeed(feed);
        System.out.println(id);
        Assertions.assertTrue(id!=0);
    }

    @DisplayName("피드 업데이트 여부 확인")
    @ParameterizedTest
    @MethodSource("UpdateFeed")
    void feedUpdateTest(long feedId , long memberId, long cocktailId, String contents){
        CreateFeedDTO feed = new CreateFeedDTO();
        feed.setCocktailId(cocktailId);
        feed.setContent("하이");
        feed.setMemberId(memberId);

        long id = feedInsertService.saveFeed(feed);
        String temp = findFeedService.findFeedById(id).getContent();
        UpdateFeedDTO updateFeedDTO = new UpdateFeedDTO();
        updateFeedDTO.setId(feedId);
        updateFeedDTO.setContent(contents);
        updateFeedDTO.setCocktailId(cocktailId);
        updateFeedDTO.setMemberId(memberId);

        Assertions.assertNotEquals(temp, findFeedService.findFeedById(feedUpdateService.updateFeed(updateFeedDTO)));
    }

}
