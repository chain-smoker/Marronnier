package com.chainsmoker.marronnier.feed.command.domain.repository;

import com.chainsmoker.marronnier.feed.command.domain.aggregate.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FeedReposiroty extends JpaRepository<Feed,Long> {

}
