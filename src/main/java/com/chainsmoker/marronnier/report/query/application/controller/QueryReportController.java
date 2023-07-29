package com.chainsmoker.marronnier.report.query.application.controller;

import com.chainsmoker.marronnier.report.query.application.dto.QueryReportDTO;
import com.chainsmoker.marronnier.report.query.application.service.QueryReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/report/*")
public class QueryReportController {

    private final QueryReportService queryReportService;

    @Autowired
    public QueryReportController(QueryReportService queryReportService) {
        this.queryReportService = queryReportService;
    }

    @GetMapping("find")
    public String findAllReport(@RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = "10") int pageSize,
                                @RequestParam(defaultValue = "id") String sortBy,
                                Model model) {

        Page<QueryReportDTO> reportPage = queryReportService.findAllReport(page, pageSize, sortBy);

        model.addAttribute("reports", reportPage.getContent());
        model.addAttribute("currentPage", reportPage.getNumber() + 1);
        model.addAttribute("totalPages", reportPage.getTotalPages());

        return "report/find";
    }


}
