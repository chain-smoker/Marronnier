package com.chainsmoker.marronnier.like.command.application.controller;

import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.like.command.application.service.PushLikeService;
import com.chainsmoker.marronnier.feed.query.domain.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

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
    public String pushLike(HttpSession httpSession, @RequestParam long feedId) {
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        pushLikeService.pushLike(likeService.saveData(sessionUser.getId(),feedId));
        return "redirect:/feed/"+feedId;
    }

    @PostMapping("/cancel" )
    public String deleteLike(HttpSession httpSession, @RequestParam long feedId) {
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        pushLikeService.cancelLike(likeService.saveData(sessionUser.getId(),feedId));
        return "redirect:/feed/"+feedId;
    }
}
