package com.chainsmoker.marronnier.feed.command.infra.service;

import com.chainsmoker.marronnier.like.command.application.service.PushLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteLikeService implements com.chainsmoker.marronnier.feed.command.domain.service.DeleteLikeService {

    private final PushLikeService pushLikeService;

    @Autowired
    public DeleteLikeService(PushLikeService pushLikeService) {
        this.pushLikeService = pushLikeService;
    }

    public void deleteLikesByFeedId(long feedId) {
        pushLikeService.deleteLikes(feedId);
    }
}
