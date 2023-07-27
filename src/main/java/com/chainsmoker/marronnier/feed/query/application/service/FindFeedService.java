package com.chainsmoker.marronnier.feed.query.application.service;

import com.chainsmoker.marronnier.feed.query.application.dto.CheckFeedDTO;
import com.chainsmoker.marronnier.feed.query.domain.entity.QueryFeed;
import com.chainsmoker.marronnier.feed.query.domain.service.CheckPhotoService;
import com.chainsmoker.marronnier.feed.query.domain.service.QueryFeedService;
import com.chainsmoker.marronnier.feed.query.infra.repository.FeedMapper;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.query.application.dto.FindPhotoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindFeedService {
    private final FeedMapper feedMapper;
    private final QueryFeedService queryFeedService;
    private final CheckPhotoService checkPhotoService;

    @Autowired
    public FindFeedService(FeedMapper feedMapper, QueryFeedService queryFeedService, CheckPhotoService checkPhotoService) {
        this.feedMapper = feedMapper;
        this.queryFeedService = queryFeedService;
        this.checkPhotoService = checkPhotoService;
    }

    public List<CheckFeedDTO> findAllFeeds() {
        List<QueryFeed> queryFeeds = feedMapper.findAllFeeds();
        List<CheckFeedDTO> checkFeedDTOS = queryFeedService.saveInfo(queryFeeds);
        queryFeedService.addDetails(checkFeedDTOS);
        return checkFeedDTOS;
    }

    public QueryFeed findFeedById(Long feedId) {
        QueryFeed queryFeed = feedMapper.findFeedById(feedId);
        return queryFeed;
    }

    public long findFeedMemberId(long feedId) {
        long feedMemberId = feedMapper.findFeedMemberIdByFeedId(feedId);

        return feedMemberId;
    }

    public List<FindPhotoDTO> findPhotoByIdAndCategory(long feedId, PhotoCategory photoCategory){
        return checkPhotoService.findPhotoByIdAndCategory(feedId,photoCategory);
    }
}
