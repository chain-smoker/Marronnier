package com.chainsmoker.marronnier.feed.command.application.controller;

import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.feed.command.application.dto.CreateFeedDTO;
import com.chainsmoker.marronnier.feed.command.application.dto.UpdateFeedDTO;
import com.chainsmoker.marronnier.feed.command.application.service.FeedDeleteService;
import com.chainsmoker.marronnier.feed.command.application.service.FeedInsertService;
import com.chainsmoker.marronnier.feed.command.application.service.FeedUpdateService;
import com.chainsmoker.marronnier.feed.command.domain.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/feed")
public class FeedController {
    private final FeedService feedService;
    private final FeedInsertService feedInsertService;
    private final FeedUpdateService feedUpdateService;
    private final FeedDeleteService feedDeleteService;
    @Autowired
    public FeedController(FeedService feedService, FeedInsertService feedInsertService, FeedUpdateService feedUpdateService, FeedDeleteService feedDeleteService) {
        this.feedService = feedService;
        this.feedInsertService = feedInsertService;
        this.feedUpdateService = feedUpdateService;
        this.feedDeleteService = feedDeleteService;
    }

    @PostMapping("")
    public String writeFeed(Authentication authentication, @RequestParam Map<String, String> feedInfos) {
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        CreateFeedDTO feedWriteDTO = feedService.saveData(feedInfos,sessionUser);//웹에서 받은 데이터 dto에 저장
        feedInsertService.saveFeed(feedWriteDTO);//db에 등록
        //피드 작성하는 코드
        return "redirect:/feed";
    }
    @PostMapping("/{feedId}")
    public String modifyFeed(@PathVariable long feedId, @RequestParam Map<String, String> feedInfos, Authentication authentication){
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        UpdateFeedDTO updateFeedDTO = feedService.saveUpdateData(feedInfos,sessionUser);
        feedUpdateService.updateFeed(updateFeedDTO);
        return "redirect:/feed";
    }

    @PostMapping("/delete/{feedId}")
    public String deleteFeed(@PathVariable long feedId){
        feedDeleteService.deleteFeed(feedId);
        return"redirect:/feed";
    }
}