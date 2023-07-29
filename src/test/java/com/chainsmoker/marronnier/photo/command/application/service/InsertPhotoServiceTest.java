package com.chainsmoker.marronnier.photo.command.application.service;


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


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class InsertPhotoServiceTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ResourceLoader loader;


    @DisplayName("이미지 업로드 테스트")
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
        actions.andExpect(status().is2xxSuccessful());

    }
}