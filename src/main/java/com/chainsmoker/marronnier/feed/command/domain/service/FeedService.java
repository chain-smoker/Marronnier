package com.chainsmoker.marronnier.feed.command.domain.service;

import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.feed.command.application.dto.CreateFeedDTO;
import com.chainsmoker.marronnier.feed.command.application.dto.UpdateFeedDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
public class FeedService {
    public CreateFeedDTO saveData(Map<String, String> data){

        CreateFeedDTO feedWriteDTO = new CreateFeedDTO();
        feedWriteDTO.setMemberId(Long.parseLong(data.get("memberId")));
        feedWriteDTO.setCocktailId(Long.parseLong(data.get("cocktailId")));
        feedWriteDTO.setContent(data.get("content"));
        return feedWriteDTO;
    }

    public UpdateFeedDTO saveUpdateData(Map<String, String> data){
        UpdateFeedDTO updateFeedDTO = new UpdateFeedDTO();
        updateFeedDTO.setId(Long.parseLong(data.get("Id")));
        updateFeedDTO.setMemberId(Long.parseLong(data.get("memberId")));
        updateFeedDTO.setCocktailId(Long.parseLong(data.get("cocktailId")));
        updateFeedDTO.setContent(data.get("content"));
        return updateFeedDTO;
    }
}
