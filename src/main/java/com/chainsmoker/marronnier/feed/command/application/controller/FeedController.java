package com.chainsmoker.marronnier.feed.command.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class FeedController {
    @PostMapping("/feed")
    public String writeFeed() {
        //피드 작성하는 코드
        return "feed/feed";
    }

    @PostMapping("/feed/{feedId")
    public String modifyFeed(@PathVariable Long feedId){


        return "feed/detail";
    }

}