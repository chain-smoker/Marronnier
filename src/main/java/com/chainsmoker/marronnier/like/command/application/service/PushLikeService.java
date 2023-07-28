package com.chainsmoker.marronnier.like.command.application.service;

import com.chainsmoker.marronnier.like.command.application.dto.LikeDTO;
import com.chainsmoker.marronnier.like.command.domain.aggregate.entity.Like;
import com.chainsmoker.marronnier.like.command.domain.aggregate.vo.LikeVO;
import com.chainsmoker.marronnier.like.command.domain.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PushLikeService {
    private final LikeRepository likeRepository;

    @Autowired
    public PushLikeService(LikeRepository likeRepository){
        this.likeRepository=likeRepository;
    }

    public void pushLike(LikeDTO likeDTO){
        Like like = new Like(likeDTO.getMemberId(),likeDTO.getFeedId());
        likeRepository.save(like);
    }

    @Transactional
    public void cancelLike(LikeDTO likeDTO) {
        likeRepository.deleteByLike(likeDTO.getMemberId(),likeDTO.getFeedId());
    }

    @Transactional
    public void deleteLikes(long feedId){
        likeRepository.deleteByfeedId(feedId);
    }
}
