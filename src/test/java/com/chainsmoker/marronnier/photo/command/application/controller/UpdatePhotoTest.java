package com.chainsmoker.marronnier.photo.command.application.controller;


import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UpdatePhotoTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ResourceLoader loader;


    @DisplayName("이미지 수정 테스트")
    @Test
    void testPhotoUpload() throws Exception {

        String fileName = "logo.png";
        Resource res = loader.getResource("classpath:/static/images/" + fileName);

        MockMultipartFile file = new MockMultipartFile("file", fileName, null, res.getInputStream());

        RequestBuilder request = MockMvcRequestBuilders.multipart("/photo/add")
                .file(file)
                .param("category", PhotoCategory.FEED.name())
                .param("originId", "1");

        ResultActions actions = mvc.perform(request);


        String updateFileName = "logo-white.png";
        Resource updateRes = loader.getResource("classpath:/static/images/" + updateFileName);

        MockMultipartFile updateFile = new MockMultipartFile("file", updateFileName, null, updateRes.getInputStream());

        RequestBuilder updateRequest = MockMvcRequestBuilders.multipart("/photo/update")
                .file(file)
                .param("category", PhotoCategory.FEED.name())
                .param("originId", "1");

        ResultActions updateActions = mvc.perform(request);
        updateActions.andExpect(status().is2xxSuccessful());

    }
}
