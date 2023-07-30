package com.chainsmoker.marronnier.report.command.application.controller;


import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.AdminDetail;
import com.chainsmoker.marronnier.report.command.application.service.AcceptReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/report")
public class AcceptReportController {

    private final AcceptReportService acceptReportService;

    @Autowired
    public AcceptReportController(AcceptReportService acceptReportService) {
        this.acceptReportService = acceptReportService;
    }

    @PostMapping("accept")
    public String acceptReport(RedirectAttributes rttr, @RequestParam Map<String, String> requestParam,
                               Authentication authentication) {

        long feedId = Long.parseLong(requestParam.get("feedId"));
        System.out.println("feedId = " + feedId);
        AdminDetail sessionAdmin = (AdminDetail) authentication.getPrincipal();

        boolean acceptResult = acceptReportService.acceptReport(feedId);

        if(!acceptResult) {
            rttr.addFlashAttribute("errorMessage", "피드 신고를 처리하는데 에러가 발생했습니다.");
        }
        return "redirect:/report/find";
    }
}
