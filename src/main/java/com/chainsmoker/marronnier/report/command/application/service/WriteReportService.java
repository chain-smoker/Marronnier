package com.chainsmoker.marronnier.report.command.application.service;

import com.chainsmoker.marronnier.report.command.application.dto.WriteReportDTO;
import com.chainsmoker.marronnier.report.command.domain.aggregate.entity.Report;
import com.chainsmoker.marronnier.report.command.domain.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriteReportService {

    private final ReportRepository reportRepository;

    @Autowired
    public WriteReportService(ReportRepository reportRepository) {

        this.reportRepository = reportRepository;
    }
    public void writeReport(WriteReportDTO writeReportDTO) {

        Report report = new Report(
                writeReportDTO.getReportReason(),
                writeReportDTO.getReportContent(),
                writeReportDTO.isApproval(),
                writeReportDTO.getReporterId(),
                writeReportDTO.getOriginId()
        );

        reportRepository.save(report);
    }
}
