package com.chainsmoker.marronnier.search;

import com.chainsmoker.marronnier.common.handler.OAuth2SuccessHandler;
import com.chainsmoker.marronnier.configuration.auth.CustomOAuth2UserService;
import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.member.command.application.service.UpdateMemberService;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.Role;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.transaction.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.oauth2Login;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class SearchCocktailTests {

    private MockMvc mvc;

    @MockBean
    UpdateMemberService updateMemberService;

    private static Stream<Arguments> searchInfo() {
        return Stream.of(
                Arguments.of(
                        "cocktail",
                        "보"
                ),
                Arguments.of(
                        "element",
                        "오"
                )

        );
    }
    @BeforeEach
    public void setup(@Autowired WebApplicationContext context) {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }


    @ParameterizedTest
    @WithMockUser
    @MethodSource("searchInfo")
    void searchTest(String category, String word) throws Exception {
        Map<String, String> updateMap = new HashMap<>();


        updateMap.put("searchCategory", category);
        updateMap.put("searchWord", word);
        String content = new ObjectMapper().writeValueAsString(updateMap);


        mvc.perform(MockMvcRequestBuilders.post("/search")
                        .with(oauth2Login()
                                .oauth2User(
                                        SessionUser
                                                .builder(1,"정지원", Role.MEMBER,"")
                                                .build()
                                )
                        )
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .characterEncoding("UTF-8")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}