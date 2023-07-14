package com.chainsmoker.marronnier.element.command.application.controller;

import com.chainsmoker.marronnier.element.command.application.dto.RegistElementDTO;
import com.chainsmoker.marronnier.element.command.application.service.RegistElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// a 등록 페이지 이동 컨트롤러

@Controller
@RequestMapping("regist")
public class RegistElementController {

    private final RegistElementService registElementService;

    @Autowired
    public RegistElementController(RegistElementService registElementService) {
        this.registElementService = registElementService;
    }


    @GetMapping("/main")
    public String registMain(Model model) {

        model.addAttribute("message", "값 전송 완료됨");

        return "cocktail/registMain";
    }


    @GetMapping("/element")
    public String registElement() {
        return "cocktail/regist/element";
    }

    @PostMapping("/element")
    public String regist(RegistElementDTO elementDTO) {
        registElementService.regist(elementDTO);
        return "cocktail/registMain";
    }
}
