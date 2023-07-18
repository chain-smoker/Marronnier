package com.chainsmoker.marronnier.element.command.application.controller;

import com.chainsmoker.marronnier.element.command.application.dto.RegistElementDTO;
import com.chainsmoker.marronnier.element.command.application.service.RegistElementService;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// a 등록 페이지 이동 컨트롤러

@Controller
@RequestMapping("cocktail/regist")
public class RegistElementController {

    private final RegistElementService registElementService;

    @Autowired      // 필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입한다
    public RegistElementController(RegistElementService registElementService) {
        this.registElementService = registElementService;
    }


    @GetMapping("/main2")
    public String registMain() {

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
