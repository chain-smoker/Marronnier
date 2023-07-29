package com.chainsmoker.marronnier.feed.command.application.service;

import com.chainsmoker.marronnier.feed.command.application.dto.UpdateFeedDTO;
import com.chainsmoker.marronnier.feed.command.domain.aggregate.entity.Feed;
import com.chainsmoker.marronnier.feed.command.domain.repository.FeedReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedUpdateService {
    private final FeedReposiroty feedReposiroty;

    @Autowired
    public FeedUpdateService(FeedReposiroty feedReposiroty) {
        this.feedReposiroty = feedReposiroty;
    }

    public long updateFeed(UpdateFeedDTO updateFeedDTO){
        Feed feed = new Feed(updateFeedDTO);
        return feedReposiroty.save(feed).getId();
    }

}
