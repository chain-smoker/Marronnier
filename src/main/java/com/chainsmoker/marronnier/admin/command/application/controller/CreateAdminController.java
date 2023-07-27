package com.chainsmoker.marronnier.admin.command.application.controller;

import com.chainsmoker.marronnier.admin.command.application.dto.CreateAdminDTO;
import com.chainsmoker.marronnier.admin.command.application.service.RegistAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class CreateAdminController {

    private final RegistAdminService registAdminService;

    @Autowired
    public CreateAdminController(RegistAdminService registAdminService) {
        this.registAdminService = registAdminService;
    }

    @GetMapping("regist")
    public String registAdminView() {
        return "admin/regist";
    }

    @PostMapping("regist")
    public String registAdmin(RedirectAttributes rttr, CreateAdminDTO createAdminDTO) {
        try {
            // @ModelAttribute("adminName") String adminName, @ModelAttribute("loginId") String loginId, @ModelAttribute("password") String password
            long addResult = registAdminService.create(createAdminDTO);
            if (addResult > 0) {
                return "redirect:/admin/login";
            } else {
                return "redirect:/admin/regist";
            }
        } catch (DataIntegrityViolationException exception) {
            String reasonValue = exception.getCause().getCause().getLocalizedMessage().split(" ")[2].replaceAll("'", "");
            String reasonKey = reasonValue.equals(createAdminDTO.getLoginId()) ? "관리자 아이디" : reasonValue.equals(createAdminDTO.getName()) ? "관리자 이름" : "";
            String errorMessage = !reasonKey.equals("") ? "이미 존재하는 " + reasonKey + " 입니다." : "회원가입 중 에러가 발생하였습니다.";
            rttr.addFlashAttribute("errorMessage", errorMessage);
            return "redirect:/admin/regist";
        }
    }
}
