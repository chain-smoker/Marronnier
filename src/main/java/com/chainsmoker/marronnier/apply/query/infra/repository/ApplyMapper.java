package com.chainsmoker.marronnier.apply.query.infra.repository;

import com.chainsmoker.marronnier.apply.query.application.dto.QueryApplyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplyMapper {
    List<QueryApplyDTO> findAllApply();
}
