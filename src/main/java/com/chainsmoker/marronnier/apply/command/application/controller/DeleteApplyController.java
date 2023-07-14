package com.chainsmoker.marronnier.apply.command.application.controller;

import com.chainsmoker.marronnier.apply.command.application.service.DeleteApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
// @RequestMapping annotation을 사용할 경우, view와 controller의 전송 방식이 맞지 않을 때 에러 발생
@RequestMapping(value="/apply/*", method = {RequestMethod.POST})
@SessionAttributes({"user"})
public class DeleteApplyController {

    private final DeleteApplyService deleteApplyService;

    @Autowired
    public DeleteApplyController(DeleteApplyService deleteApplyService) {

        this.deleteApplyService = deleteApplyService;
    }

    @DeleteMapping("delete/{id}")
    // @PathVariable("id") 경로변수 설정
    public String delete(@PathVariable("id") long applyId) {

        deleteApplyService.delete(applyId);

        return "redirect:/";
    }

}
