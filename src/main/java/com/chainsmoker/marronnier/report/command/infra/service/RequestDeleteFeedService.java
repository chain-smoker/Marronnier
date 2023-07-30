package com.chainsmoker.marronnier.report.command.infra.service;

import com.chainsmoker.marronnier.common.annotation.InfraService;
import com.chainsmoker.marronnier.feed.command.application.service.FeedDeleteService;
import com.chainsmoker.marronnier.report.command.domain.service.RequestDeleteFeed;
import org.springframework.beans.factory.annotation.Autowired;

@InfraService
public class RequestDeleteFeedService implements RequestDeleteFeed {

    private final FeedDeleteService feedDeleteService;

    @Autowired
    private RequestDeleteFeedService(FeedDeleteService feedDeleteService) {
        this.feedDeleteService = feedDeleteService;
    }


    @Override
    public void deleteFeed(long feedId) {
        feedDeleteService.deleteFeed(feedId);
    }
}
