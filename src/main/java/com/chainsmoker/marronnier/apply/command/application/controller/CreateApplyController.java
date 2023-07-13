package com.chainsmoker.marronnier.apply.command.application.controller;

import com.chainsmoker.marronnier.apply.command.application.dto.CreateApplyDTO;
import com.chainsmoker.marronnier.apply.command.application.service.RegistApplyService;
import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/apply/*")
@SessionAttributes({"user"})
public class CreateApplyController {

    private final RegistApplyService registApplyService;

    @Autowired
    public CreateApplyController(RegistApplyService registApplyService) {
        this.registApplyService = registApplyService;
    }

    @GetMapping("add")
    public String addApplyView(HttpSession session) {
        return "apply/add";
    }

    @PostMapping("add")
    public String addApply(@RequestParam Map<String, String> applyInfos,
                           HttpSession session) {

        // 로그인된 사용자 id 가져오기
        SessionUser sessionUser = (SessionUser) session.getAttribute("user");
        long requesterId = sessionUser.getId();

        // 사용자 입력값 DTO에 담기
        String title = applyInfos.get("title");
        String content = applyInfos.get("content");
        String category = applyInfos.get("category");
        boolean isApproval = Boolean.parseBoolean(applyInfos.get("isApproval"));

        CreateApplyDTO createApplyDTO =
                new CreateApplyDTO(title, content, category, isApproval, requesterId);

        registApplyService.create(createApplyDTO);

        return "redirect:/";
    }

}
