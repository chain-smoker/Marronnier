package com.chainsmoker.marronnier.feed.query.domain.repository;

import com.chainsmoker.marronnier.feed.query.domain.entity.QueryFeed;

import java.util.List;

/*
추후 수정 예정입니다.
 */
public interface FeedM {
    List<QueryFeed> findAllFeeds();
}
