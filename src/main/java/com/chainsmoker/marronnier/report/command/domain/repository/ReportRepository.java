package com.chainsmoker.marronnier.report.command.domain.repository;

import com.chainsmoker.marronnier.report.command.domain.aggregate.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

// 여기엔 @Repository 안달아도 JpaRepository 상속받았기 때문에 자동으로 빈으로 등록되는건지?
public interface ReportRepository extends JpaRepository<Report, Long> {
}
