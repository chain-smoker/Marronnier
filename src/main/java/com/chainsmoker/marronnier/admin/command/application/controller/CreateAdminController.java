package com.chainsmoker.marronnier.admin.command.application.controller;

import com.chainsmoker.marronnier.admin.command.application.dto.CreateAdminDTO;
import com.chainsmoker.marronnier.admin.command.application.service.RegistAdminService;
import com.chainsmoker.marronnier.admin.command.domain.aggragate.entity.vo.PasswordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
    public String registAdmin( @ModelAttribute("name") String adminName, @ModelAttribute("loginId") String loginId, @ModelAttribute("password") String password) {
        // @ModelAttribute("adminName") String adminName, @ModelAttribute("loginId") String loginId, @ModelAttribute("password") String password
        CreateAdminDTO createAdminDTO = new CreateAdminDTO(loginId, password, adminName);
        System.out.println(createAdminDTO.toString());
        long addResult = registAdminService.create(createAdminDTO);
        if (addResult > 0) {
            return "redirect:/admin/login";
        } else {
            return "redirect:/admin/regist";
        }
    }

}
