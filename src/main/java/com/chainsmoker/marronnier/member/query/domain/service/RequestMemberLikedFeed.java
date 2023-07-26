package com.chainsmoker.marronnier.member.query.domain.service;

import com.chainsmoker.marronnier.feed.query.domain.entity.QueryFeed;

import java.util.List;

public interface RequestMemberLikedFeed {
    List<QueryFeed> findLikedFeed(long memberId);
}
