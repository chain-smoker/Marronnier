package com.chainsmoker.marronnier.apply.query.application.controller;

import com.chainsmoker.marronnier.apply.query.application.dto.QueryApplyDTO;
import com.chainsmoker.marronnier.apply.query.application.service.QueryApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/apply/*")
public class QueryApplyController {

    private final QueryApplyService queryApplyService;

    @Autowired
    public QueryApplyController(QueryApplyService queryApplyService) {
        this.queryApplyService = queryApplyService;
    }

    @GetMapping("find")
    public String getApplys(@RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "5") int pageSize,
                            @RequestParam(defaultValue = "id") String sortBy,
                            Model model) {

        // 서비스를 통해 페이징 처리된 요청 목록 가져오기
        Page<QueryApplyDTO> applyPage = queryApplyService.getApplys(page, pageSize, sortBy);

        // 템플릿으로 데이터 전달(Model에 추가)
        model.addAttribute("applys", applyPage.getContent());
        model.addAttribute("currentPage", applyPage.getNumber() + 1);
        model.addAttribute("totalPages", applyPage.getTotalPages());

        return "apply/find";

    }
}
