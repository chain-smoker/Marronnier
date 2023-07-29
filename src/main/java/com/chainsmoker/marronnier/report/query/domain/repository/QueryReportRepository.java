package com.chainsmoker.marronnier.report.query.domain.repository;

import com.chainsmoker.marronnier.report.query.domain.entity.QueryReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryReportRepository extends JpaRepository<QueryReport, Long> {
}
