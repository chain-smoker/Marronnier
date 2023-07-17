package com.chainsmoker.marronnier.feed.command.application.service;

import com.chainsmoker.marronnier.feed.command.domain.repository.FeedReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedDeleteService {
    private  final FeedReposiroty feedReposiroty;
    @Autowired
    public FeedDeleteService(FeedReposiroty feedReposiroty) {
        this.feedReposiroty = feedReposiroty;
    }


    public void deleteFeed(long feedId){
        feedReposiroty.deleteById(feedId);
    }

}
