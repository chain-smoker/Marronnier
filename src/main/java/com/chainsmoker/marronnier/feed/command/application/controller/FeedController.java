package com.chainsmoker.marronnier.feed.command.application.controller;

import com.chainsmoker.marronnier.feed.command.application.dto.CreateFeedDTO;
import com.chainsmoker.marronnier.feed.command.application.service.FeedInsertService;
import com.chainsmoker.marronnier.feed.command.domain.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/feed")
public class FeedController {
    private final FeedService feedService;
    private final FeedInsertService feedInsertService;
    @PostMapping("")
    public String writeFeed(@RequestParam Map<String, String> feedInfos) {
        CreateFeedDTO feedWriteDTO = feedService.saveData(feedInfos);//웹에서 받은 데이터 dto에 저장
        feedInsertService.saveFeed(feedWriteDTO);//db에 등록
        //피드 작성하는 코드
        return "feed/feed";
    }
    @PostMapping("/{feedId}")
    public String modifyFeed(@PathVariable Long feedId){

        return "feed/detail";
    }

}