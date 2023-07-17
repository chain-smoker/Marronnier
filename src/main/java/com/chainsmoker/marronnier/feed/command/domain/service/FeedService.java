package com.chainsmoker.marronnier.feed.command.domain.service;

import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.feed.command.application.dto.CreateFeedDTO;
import com.chainsmoker.marronnier.feed.command.application.dto.UpdateFeedDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
public class FeedService {
    public CreateFeedDTO saveData(Map<String, String> data,SessionUser sessionUser){

        CreateFeedDTO feedWriteDTO = new CreateFeedDTO();
        feedWriteDTO.setMemberId(sessionUser.getId());
        feedWriteDTO.setCocktailId(Long.parseLong(data.get("cocktailId")));
        feedWriteDTO.setContent(data.get("content"));
        return feedWriteDTO;
    }

    public UpdateFeedDTO saveUpdateData(Map<String, String> data,SessionUser sessionUser){
        UpdateFeedDTO updateFeedDTO = new UpdateFeedDTO();
        updateFeedDTO.setId(Long.parseLong(data.get("Id")));
        updateFeedDTO.setMemberId(sessionUser.getId());
        updateFeedDTO.setCocktailId(Long.parseLong(data.get("cocktailId")));
        updateFeedDTO.setContent(data.get("content"));
        return updateFeedDTO;
    }
}
