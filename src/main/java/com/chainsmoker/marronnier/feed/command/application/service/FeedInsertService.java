package com.chainsmoker.marronnier.feed.command.application.service;

import com.chainsmoker.marronnier.feed.command.application.dto.FeedWriteDTO;
import com.chainsmoker.marronnier.feed.command.domain.aggregate.entity.Feed;
import com.chainsmoker.marronnier.feed.command.domain.repository.FeedReposiroty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedInsertService {
    private final FeedReposiroty feedReposiroty;

    public void saveFeed(FeedWriteDTO feedWriteDTO){
        feedReposiroty.save(Feed.builder()
                .content( feedWriteDTO.getContent())
                .memberId(feedWriteDTO.getMemberId())
                .cocktailId(feedWriteDTO.getCocktailId())
                .build()
        );
    }
}
