package com.chainsmoker.marronnier.main.query.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/main")
public class ErrorController {

    @GetMapping("error")
    public String ErrorView(HttpServletRequest request, HttpServletResponse response, Model model) {
        String errorTitle = (String) request.getAttribute("errorTitle");
        model.addAttribute("errorMessage", errorTitle);
        String errorMessage = (String) request.getAttribute("errorMessage");
        model.addAttribute("errorMessage", errorMessage);
        return "main/error";
    }
}
