package com.chainsmoker.marronnier.report.command.application.controller;

import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.report.command.application.dto.WriteReportDTO;
import com.chainsmoker.marronnier.report.command.application.service.WriteReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/report/*")
public class WriteReportController {

    private final WriteReportService writeReportService;

    @Autowired
    public WriteReportController(WriteReportService writeReportService) {
        this.writeReportService = writeReportService;
    }

    @GetMapping("")
    public String report() {

        return "report/write";
    }

    @PostMapping("write")
    public void writeReport(@RequestParam String reportReason,
                              @RequestParam String reportContent,
                              @RequestParam boolean isApproval,
                              @RequestParam long originId,
                              Authentication authentication) {

        // 로그인된 사용자 id 가져오기
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        long reporterId = sessionUser.getId();

        WriteReportDTO writeReportDTO = new WriteReportDTO();

        writeReportDTO.setReportReason(reportReason);
        writeReportDTO.setReportContent(reportContent);
        writeReportDTO.setApproval(isApproval);
        writeReportDTO.setOriginId(originId);
        writeReportDTO.setReporterId(reporterId);

        writeReportService.writeReport(writeReportDTO);

    }
}
