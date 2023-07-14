package com.chainsmoker.marronnier.apply.query.infra.repository;

import com.chainsmoker.marronnier.apply.query.domain.entity.QueryApply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryApplyRepository extends JpaRepository<QueryApply, Long> {
}
