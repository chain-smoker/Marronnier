package com.chainsmoker.marronnier.like.query.domain.service;

import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;

import java.util.List;

public interface CheckFeedService {
    List<CheckFeedDTO> findLikedFeedsById(List<Long> feedIds);
}
