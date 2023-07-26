package com.chainsmoker.marronnier.member.command.application.controller;


import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.member.command.application.dto.UpdateMemberDTO;
import com.chainsmoker.marronnier.member.command.application.service.UpdateMemberService;
import com.chainsmoker.marronnier.member.command.domain.aggregate.entity.EnumType.GenderEnum;
import com.chainsmoker.marronnier.member.command.domain.aggregate.vo.BirthDateVO;
import com.chainsmoker.marronnier.member.command.domain.exception.BirthDateAfterException;
import com.chainsmoker.marronnier.member.command.domain.service.FindMemberRequest;
import com.chainsmoker.marronnier.member.query.application.dto.FindMemberDTO;
import com.chainsmoker.marronnier.member.query.application.service.FindMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class UpdateMemberController {
    private final UpdateMemberService updateMemberService;
    private final FindMemberRequest findMemberRequest;

    @Autowired
    public UpdateMemberController(UpdateMemberService updateMemberService, FindMemberRequest findMemberRequest) {
        this.updateMemberService = updateMemberService;
        this.findMemberRequest = findMemberRequest;
    }


    @GetMapping("info")
    public String additionalMemberInformation(Authentication authentication, Model model) {
        SessionUser authenticationMember = (SessionUser) authentication.getPrincipal();
        boolean memberIsAuthenticated = authentication.isAuthenticated();
        FindMemberDTO member = findMemberRequest.getMemberById(authenticationMember.getId());
        model.addAttribute("member", member);
        model.addAttribute("memberIsAuthenticated", memberIsAuthenticated);
        return "member/additional";
    }

    @PostMapping("update")
    public String updateMemberInformation(RedirectAttributes rttr, @RequestParam Map<String, String> updateMap, Authentication authentication)
            throws ServletException, IOException {
        try {
            UpdateMemberDTO updateMemberDTO = new UpdateMemberDTO();
            if (!updateMap.get("address").equals("")) {
                updateMemberDTO.setAddress(updateMap.get("address"));
            }
            if (!updateMap.get("job").equals("")) {
                updateMemberDTO.setJob(updateMap.get("job"));
            }
            if(!updateMap.get("birthDate").equals("")) {
                updateMemberDTO.setBirthDate(new BirthDateVO(LocalDate.parse(updateMap.get("birthDate"))));
            }
            if(!updateMap.get("gender").equals("")) {
                updateMemberDTO.setGender(GenderEnum.valueOf(updateMap.get("gender")));
            }

            System.out.println("sessionUser = " + authentication.getPrincipal());

            SessionUser member = (SessionUser) authentication.getPrincipal();
            long memberId = member.getId();

            boolean updateMemberInformation = updateMemberService.updateMemberInformation(memberId, updateMemberDTO);
            if (updateMemberInformation) {
                return "redirect:/home";
            } else {
                return "redirect:/member/info";
            }
        } catch (Exception exception) {
            if (exception.getClass() == BirthDateAfterException.class) {
                rttr.addFlashAttribute("errorMessage", exception.getMessage());
            }
            return "redirect:/member/info";
        }
    }
}
