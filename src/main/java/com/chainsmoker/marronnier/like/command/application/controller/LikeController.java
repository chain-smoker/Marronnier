package com.chainsmoker.marronnier.like.command.application.controller;

import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.like.command.application.service.PushLikeService;
import com.chainsmoker.marronnier.feed.query.domain.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/like")
public class LikeController {

    private final PushLikeService pushLikeService;
    private final LikeService likeService;

    @Autowired
    public LikeController(PushLikeService pushLikeService, LikeService likeService) {
        this.pushLikeService = pushLikeService;
        this.likeService = likeService;
    }
    @PostMapping("")
    @ResponseBody
    public Map<String, Integer> pushLike(Authentication authentication, @RequestParam long feedId) {
        Map<String , Integer> map = new HashMap<>();
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        pushLikeService.pushLike(likeService.saveData(sessionUser.getId(),feedId));
        map.put("numberOfLike",likeService.numberOfLikes(feedId));
        return map;
    }

    @PostMapping("/cancel" )
    @ResponseBody
    public  Map<String, Integer> deleteLike(Authentication authentication, @RequestParam long feedId) {
        Map<String , Integer> map = new HashMap<>();
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        pushLikeService.cancelLike(likeService.saveData(sessionUser.getId(),feedId));
        map.put("numberOfLike",likeService.numberOfLikes(feedId));
        return map;
    }
}
