package com.chainsmoker.marronnier.member;


import com.chainsmoker.marronnier.common.handler.OAuth2SuccessHandler;
import com.chainsmoker.marronnier.configuration.auth.CustomOAuth2UserService;
import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.member.command.application.service.UpdateMemberService;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.Role;
import com.chainsmoker.marronnier.member.query.application.service.FindMemberLikedFeedService;
import com.chainsmoker.marronnier.member.query.application.service.FindMemberWroteFeedService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.oauth2Login;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
public class GetMemberFeedTests {

    @Autowired
    private FindMemberWroteFeedService findMemberWroteFeedService;

    @Autowired
    private FindMemberLikedFeedService findMemberLikedFeedService;

    @DisplayName("사용자 id를 통해 사용자가 작성한 피드 목록 조회 테스트")
    @ParameterizedTest
    @ValueSource(longs = {1})
    void testGetMemberWroteFeedTests(long memberId) {
        Assertions.assertDoesNotThrow(
                () -> findMemberWroteFeedService.findWroteFeed(memberId)
        );
    }

    @DisplayName("사용자 id를 통해 사용자가 좋아요한 피드 목록 조회 테스트")
    @ParameterizedTest
    @ValueSource(longs = {1})
    void testGetMemberLikedFeedTests(long memberId) {
        Assertions.assertDoesNotThrow(
                () -> findMemberLikedFeedService.findLikedFeed(memberId)
        );
    }
}
