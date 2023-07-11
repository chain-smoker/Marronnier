package com.chainsmoker.marronnier.feed.query.application.controller;

import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;
import com.chainsmoker.marronnier.feed.query.application.service.FindFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/feed")
public class QueryFeedController {
    private final FindFeedService findFeedService;
    @GetMapping("")
    public String viewAllFeed(Model model) {
        List<CheckFeedDTO> checkFeedDTO = findFeedService.findAllFeeds();

        checkFeedDTO.forEach(System.out::println);
        model.addAttribute("feeds",checkFeedDTO);

        return "feed/feed";
    }

    @GetMapping("/write")
    public String moveToFeedWrite() {
        System.out.println("여기까지옴");
        //피드 작성하는 페이지로 이동
        //근데 피드는 여기서 작성하는게 맞았나?
        return "feed/write";
    }

    @GetMapping("/{feedId}")
    public String feedDetail(@PathVariable Long feedId) {
        //pathvariable에 해당하는 피드 보는 페이지


        return "feed/detail";
    }

}