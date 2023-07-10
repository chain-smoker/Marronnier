package com.chainsmoker.marronnier.feed.query.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class FeedQController {
    @GetMapping("/feed")
    public String viewAllFeed() {
        //모든 피드를 보여주는 코드 추가
        return "feed/feed";
    }

    @GetMapping("/feed/write")
    public String moveToFeedWrite() {
        //피드 작성하는 페이지로 이동
        //근데 피드는 여기서 작성하는게 맞았나?
        return "feed/write";
    }

    @GetMapping("/feed/{feedId}")
    public String feedDetail(@PathVariable Long feedId) {
        //pathvariable에 해당하는 피드 보는 페이지


        return "feed/detail";
    }

}