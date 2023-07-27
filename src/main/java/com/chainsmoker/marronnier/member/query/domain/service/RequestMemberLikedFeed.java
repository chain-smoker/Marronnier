package com.chainsmoker.marronnier.member.query.domain.service;

import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;

import java.util.List;

public interface RequestMemberLikedFeed {

    List<CheckFeedDTO> findLikedFeed(long memberId);
}
