package com.chainsmoker.marronnier.member;

import com.chainsmoker.marronnier.common.handler.OAuth2SuccessHandler;
import com.chainsmoker.marronnier.configuration.auth.CustomOAuth2UserService;
import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.member.command.application.service.UpdateMemberService;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;


import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.stream.Stream;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

@SpringBootTest
@AutoConfigureDataJpa
@ComponentScan(basePackages = "com.chainsmoker.marronnier.configuration.auth") // 커스텀한 security 패키지 주소
public class ProfileUpdateTests {

    private MockMvc mvc;

    @MockBean
    UpdateMemberService updateMemberService;

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private CustomOAuth2UserService customOAuth2UserService;

    @MockBean
    private OAuth2SuccessHandler oAuth2SuccessHandler;

    @BeforeEach
    public void setup(@Autowired WebApplicationContext context) {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    private static Stream<Arguments> updateAdditionalInfo() {
        return Stream.of(
                Arguments.of(
                        "경기도 성남시",
                        "",
                        "",
                        ""
                ),
                Arguments.of(
                        "경기도 성남시",
                        "힉생",
                        "",
                        ""
                ),
                Arguments.of(
                        "경기도 성남시",
                        "힉생",
                        "1998-01-09",
                        ""
                ),
                Arguments.of(
                        "경기도 성남시",
                        "힉생",
                        "1998-01-09",
                        "MALE"
                )

        );
    }


    @ParameterizedTest(name = "사용자 추가 정보 업데이트 테스트 | 주소 : {0} , 직업 : {1}, 생년월일 : {2}, 성별 : {3} ")
    @MethodSource("updateAdditionalInfo")
    @WithMockUser
    void testUpdateAdditionalTests(String address, String job, String birthDate, String gender) throws Exception {

        MultiValueMap<String, String> updateMap = new LinkedMultiValueMap<>();

        updateMap.add("address", address);
        updateMap.add("job", job);
        updateMap.add("birthDate", birthDate);
        updateMap.add("gender", gender);

        mvc.perform(post("/member/update")
                        .with(oauth2Login()
                                .oauth2User(
                                        SessionUser
                                                .builder(1,"정지원",Role.MEMBER,"")
                                                .build()
                                )
                        )
                        .params(updateMap)
                        .contentType(MediaType.MULTIPART_FORM_DATA) //보내는 데이터의 타입을 명시
                )
                .andExpect(status().is3xxRedirection());
    }

}
