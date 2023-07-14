package com.chainsmoker.marronnier.feed.query.domain.service;

import java.util.Map;

public interface CheckLikeService {
    int checkLikeByMemberIdAndFeedId(Map<String,Long> parameter);
    int numberOfLike(long feedId);
}
