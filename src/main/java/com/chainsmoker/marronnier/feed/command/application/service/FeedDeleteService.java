package com.chainsmoker.marronnier.feed.command.application.service;

import com.chainsmoker.marronnier.feed.command.domain.repository.FeedReposiroty;
import com.chainsmoker.marronnier.feed.command.domain.service.DeleteLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedDeleteService {
    private  final FeedReposiroty feedReposiroty;
    private final DeleteLikeService deleteLikeService;
    @Autowired
    public FeedDeleteService(FeedReposiroty feedReposiroty, DeleteLikeService deleteLikeService) {
        this.feedReposiroty = feedReposiroty;
        this.deleteLikeService = deleteLikeService;
    }


    public void deleteFeed(long feedId){
        feedReposiroty.deleteById(feedId);
        deleteLikeService.deleteLikesByFeedId(feedId);
    }

}
