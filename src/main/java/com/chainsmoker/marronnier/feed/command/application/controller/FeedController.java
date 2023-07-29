package com.chainsmoker.marronnier.feed.command.application.controller;

import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.feed.command.application.dto.CreateFeedDTO;
import com.chainsmoker.marronnier.feed.command.application.dto.UpdateFeedDTO;
import com.chainsmoker.marronnier.feed.command.application.service.FeedDeleteService;
import com.chainsmoker.marronnier.feed.command.application.service.FeedInsertService;
import com.chainsmoker.marronnier.feed.command.application.service.FeedPhotoService;
import com.chainsmoker.marronnier.feed.command.application.service.FeedUpdateService;
import com.chainsmoker.marronnier.feed.command.domain.service.FeedService;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/feed")
public class FeedController {
    private final FeedService feedService;
    private final FeedInsertService feedInsertService;
    private final FeedUpdateService feedUpdateService;
    private final FeedDeleteService feedDeleteService;
    private final FeedPhotoService feedPhotoService;
    @Autowired
    public FeedController(FeedService feedService, FeedInsertService feedInsertService, FeedUpdateService feedUpdateService, FeedDeleteService feedDeleteService, FeedPhotoService feedPhotoService) {
        this.feedService = feedService;
        this.feedInsertService = feedInsertService;
        this.feedUpdateService = feedUpdateService;
        this.feedDeleteService = feedDeleteService;
        this.feedPhotoService = feedPhotoService;
    }

    @PostMapping("")
    public String writeFeed(Authentication authentication, @RequestParam MultipartFile photo , @RequestParam Map<String, String> feedInfos) throws IOException {
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        CreateFeedDTO feedWriteDTO = feedService.saveData(feedInfos,sessionUser);//웹에서 받은 데이터 dto에 저장
        if(photo!=null){
            feedPhotoService.savePhoto(feedInsertService.saveFeed(feedWriteDTO),photo, PhotoCategory.valueOf("FEED"));
        }else {
            feedInsertService.saveFeed(feedWriteDTO);//db에 등록
            /*
            여기서 db에 저장된 사진을 갖다 넣는게 좋을지..
             */
        }
        //피드 작성하는 코드
        return "redirect:/feed";
    }

    @PostMapping("/{feedId}")
    public String modifyFeed(@PathVariable long feedId,@RequestParam MultipartFile photo, @RequestParam Map<String, String> feedInfos, Authentication authentication) throws IOException {
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        UpdateFeedDTO updateFeedDTO = feedService.saveUpdateData(feedInfos,sessionUser);
        System.out.println("photo = " + photo.isEmpty());
        if(!photo.isEmpty()){
            feedPhotoService.updatePhoto(feedUpdateService.updateFeed(updateFeedDTO),photo, PhotoCategory.valueOf("FEED"));
        }else{
            feedUpdateService.updateFeed(updateFeedDTO);
        }
        return "redirect:/feed";
    }

    @PostMapping("/delete/{feedId}")
    public String deleteFeed(@PathVariable long feedId){
        feedDeleteService.deleteFeed(feedId);
        return"redirect:/feed";
    }
}