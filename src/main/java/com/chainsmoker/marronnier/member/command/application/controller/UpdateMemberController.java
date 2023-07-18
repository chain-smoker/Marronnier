package com.chainsmoker.marronnier.member.command.application.controller;


import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.member.command.application.dto.UpdateMemberDTO;
import com.chainsmoker.marronnier.member.command.application.service.UpdateMemberService;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.GenderEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class UpdateMemberController {
    private final UpdateMemberService updateMemberService;
    @Autowired
    public UpdateMemberController(UpdateMemberService updateMemberService) {
        this.updateMemberService = updateMemberService;
    }


    @GetMapping("info")
    public String additionalMemberInformation(Authentication authentication, Model model) {
        SessionUser member = (SessionUser) authentication.getPrincipal();
        model.addAttribute("member", member);
        return "member/additional";
    }

    @PostMapping("update")
    public String updateMemberInformation(@RequestParam Map<String, String> updateMap, Authentication authentication) {

        UpdateMemberDTO updateMemberDTO = new UpdateMemberDTO(
                updateMap.get("address"),
                updateMap.get("job"),
                LocalDate.parse(updateMap.get("birthDate")),
                GenderEnum.valueOf(updateMap.get("gender")),
                updateMap.get("profileImage"));
        System.out.println("updateMemberDTO = " + updateMemberDTO);

        SessionUser member = (SessionUser) authentication.getPrincipal();
        long memberId = member.getId();

        boolean updateMemberInformation = updateMemberService.updateMemberInformation(memberId, updateMemberDTO);
        if (updateMemberInformation) {
           return "redirect:/home";
        } else {
            return "redirect:/member/info";
        }
    }

}
