package com.chainsmoker.marronnier.feed.command.domain.service;

import com.chainsmoker.marronnier.feed.command.application.dto.CreateFeedDTO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FeedService {
    public CreateFeedDTO saveData(Map<String, String> data){
        CreateFeedDTO feedWriteDTO   = new CreateFeedDTO();
        feedWriteDTO.setMemberId(Long.parseLong(data.get("memberId")));
        feedWriteDTO.setCocktailId(Long.parseLong(data.get("cocktailId")));
        feedWriteDTO.setContent(data.get("content"));
        return feedWriteDTO;
    }
}
