package com.chainsmoker.marronnier.report.command.application.controller;

import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.AdminDetail;
import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.EnumType.AdminRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

import java.util.HashMap;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ComponentScan(basePackages = "com.chainsmoker.marronnier.configuration.auth")
class AcceptReportControllerTest {


    private MockMvc mvc;

    @BeforeEach
    public void setup(@Autowired WebApplicationContext context) {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser
    void testAcceptReportTests() throws Exception {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("feedId", "1");

        mvc.perform(post("/report/accept")
                        .with(user(new AdminDetail(1L,"adminId", "adminName","1234", AdminRole.ADMIN)))
                .params(params)
        ).andExpect(status().is3xxRedirection());
    }
}