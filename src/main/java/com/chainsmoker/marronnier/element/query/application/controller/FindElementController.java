package com.chainsmoker.marronnier.element.query.application.controller;

import com.chainsmoker.marronnier.element.query.application.dto.FindElementDTO;
import com.chainsmoker.marronnier.element.query.application.service.FindElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("find")
public class FindElementController {
    private final FindElementService findElementService;

    @Autowired
    public FindElementController(FindElementService findElementService){
        this.findElementService=findElementService;
    }

    @GetMapping("/element")
    public String findAllElement(Model model){
        List<FindElementDTO> elements=findElementService.findAllElement();
        model.addAttribute("elements", elements);
        FindElementDTO element=findElementService.findByElementId(1L);
        System.out.println("element = " + element);
        return "cocktail/find/element";
    }
}
