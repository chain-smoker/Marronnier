package com.chainsmoker.marronnier.feed.query.infra.repository;

import com.chainsmoker.marronnier.feed.query.domain.entity.QueryFeed;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    List<QueryFeed> findAllFeeds();
    QueryFeed findFeedById(long id);

    long findFeedMemberIdByFeedId(long feedId);
}
