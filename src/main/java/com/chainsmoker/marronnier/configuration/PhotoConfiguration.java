package com.chainsmoker.marronnier.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.util.Arrays;
import java.util.List;

@Configuration
public class PhotoConfiguration implements WebMvcConfigurer {

    private final String uploadImagesPath;

    public PhotoConfiguration(@Value("${custom.path.upload-images}") String uploadImagesPath) {
        this.uploadImagesPath = uploadImagesPath;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 기본 resources/upload-images 경로 설정
        registry.addResourceHandler("/resources/upload-images/**")
                .addResourceLocations("classpath:/META-INF/resources/");

        List<String> imageFolders = Arrays.asList("recipe", "element", "feed");
        for (String imageFolder : imageFolders) {
            // 각 이미지 폴더에 대한 경로 설정 (예: /static/upload-images/recipe/)
            registry.addResourceHandler("/static/upload-images/" + imageFolder + "/**")
                    .addResourceLocations("file:///" + uploadImagesPath + imageFolder + "/")
                    .setCachePeriod(3600)   // 정적 자원 캐싱 1시간 설정
                    .resourceChain(true)
                    .addResolver(new PathResourceResolver());
        }
    }
}