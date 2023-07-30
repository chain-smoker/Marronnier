package com.chainsmoker.marronnier.report.command.application.service;

import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.Member;
import com.chainsmoker.marronnier.report.command.domain.aggregate.entity.Report;
import com.chainsmoker.marronnier.report.command.domain.repository.ReportRepository;
import com.chainsmoker.marronnier.report.command.domain.service.RequestDeleteFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AcceptReportService {

    private final RequestDeleteFeed requestDeleteFeed;
    private final ReportRepository reportRepository;

    @Autowired
    public AcceptReportService(RequestDeleteFeed requestDeleteFeed, ReportRepository reportRepository) {
        this.requestDeleteFeed = requestDeleteFeed;
        this.reportRepository = reportRepository;
    }

    @Transactional
    public boolean acceptReport(long reportId) {
        Optional<Report> findReport = reportRepository.findById(reportId);
        if(findReport.isPresent()) {
            Report updateReport = findReport.get();
            updateReport.setApproval(true);
            requestDeleteFeed.deleteFeed(updateReport.getOriginId());
            return true;
        } else {
            return false;
        }
    }
}
