package com.chainsmoker.marronnier.report.query.application.service;

import com.chainsmoker.marronnier.apply.query.application.dto.QueryApplyDTO;
import com.chainsmoker.marronnier.apply.query.domain.entity.QueryApply;
import com.chainsmoker.marronnier.report.query.application.dto.QueryReportDTO;
import com.chainsmoker.marronnier.report.query.domain.entity.QueryReport;
import com.chainsmoker.marronnier.report.query.domain.repository.QueryReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class QueryReportService {

    private final QueryReportRepository reportRepository;

    @Autowired
    public QueryReportService(QueryReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Page<QueryReportDTO> findAllReport(int pageNo, int pageSize, String sortBy) {

        // 페이지 번호는 0부터 시작
        int pageNumber = pageNo -1;
        // 정렬 기준과 방향(desc)
        Sort sort = Sort.by(sortBy).descending();
        // 페이징 정보가 들어있는 객체
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<QueryReport> reportPage = reportRepository.findAll(pageable);

        return reportPage.map(this::toDTO);
    }

    // Entity -> DTO 변환 로직
    private QueryReportDTO toDTO(QueryReport queryReport) {
        QueryReportDTO dto = new QueryReportDTO();
        dto.setId(queryReport.getId());
        dto.setReportReason(queryReport.getReportReason());
        dto.setReportContent(queryReport.getReportContent());
        dto.setApproval(queryReport.isApproval());
        dto.setReporterId(queryReport.getReporterId());
        dto.setOriginId(queryReport.getOriginId());

        return dto;
    }

}
