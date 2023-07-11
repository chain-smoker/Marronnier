package com.chainsmoker.marronnier.feed.command.domain.service;

import com.chainsmoker.marronnier.feed.command.application.dto.FeedWriteDTO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FeedService {
    public FeedWriteDTO saveData(Map<String, String> data){
        FeedWriteDTO feedWriteDTO   = new FeedWriteDTO();
        feedWriteDTO.setMemberId(Long.parseLong(data.get("memberId")));
        feedWriteDTO.setCocktailId(Long.parseLong(data.get("cocktailId")));
        feedWriteDTO.setContent(data.get("content"));
        return feedWriteDTO;
    }
}
