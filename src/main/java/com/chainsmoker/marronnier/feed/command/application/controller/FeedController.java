package com.chainsmoker.marronnier.feed.command.application.controller;

import com.chainsmoker.marronnier.feed.command.application.dto.CreateFeedDTO;
import com.chainsmoker.marronnier.feed.command.application.dto.UpdateFeedDTO;
import com.chainsmoker.marronnier.feed.command.application.service.FeedInsertService;
import com.chainsmoker.marronnier.feed.command.application.service.FeedUpdateService;
import com.chainsmoker.marronnier.feed.command.domain.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/feed")
public class FeedController {
    private final FeedService feedService;
    private final FeedInsertService feedInsertService;
    private final FeedUpdateService feedUpdateService;
    @Autowired
    public FeedController(FeedService feedService, FeedInsertService feedInsertService, FeedUpdateService feedUpdateService) {
        this.feedService = feedService;
        this.feedInsertService = feedInsertService;
        this.feedUpdateService = feedUpdateService;
    }

    @PostMapping("")
    public String writeFeed(HttpSession httpSession, @RequestParam Map<String, String> feedInfos) {
        CreateFeedDTO feedWriteDTO = feedService.saveData(feedInfos);//웹에서 받은 데이터 dto에 저장
        feedInsertService.saveFeed(feedWriteDTO);//db에 등록
        //피드 작성하는 코드
        return "redirect:/feed";
    }
    @PostMapping("/{feedId}")
    public String modifyFeed(@PathVariable long feedId, @RequestParam Map<String, String> feedInfos){
        UpdateFeedDTO updateFeedDTO = feedService.saveUpdateData(feedInfos);
        feedUpdateService.updateFeed(updateFeedDTO);
        return "redirect:/feed/"+feedId;
    }
}