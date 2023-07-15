package com.chainsmoker.marronnier.basket.command.application.controller;

import com.chainsmoker.marronnier.basket.command.application.dto.CreateBasketDTO;
import com.chainsmoker.marronnier.basket.command.application.service.RegistBasketService;
import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/basket")
@SessionAttributes("user")
public class CreateBasketController {

    private final RegistBasketService registBasketService;
    @Autowired
    public CreateBasketController(RegistBasketService registBasketService) {
        this.registBasketService = registBasketService;
    }

    @GetMapping("add")
    public String addBasketView(HttpSession session) {
        return "basket/add";
    }

    @PostMapping("add")
    public String addBasket(Authentication authentication, @ModelAttribute("cockTailRecipeId") long cockTailRecipeId) {
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        long memberId = sessionUser.getId();

        CreateBasketDTO createBasketDTO = new CreateBasketDTO(memberId, cockTailRecipeId);
        long addResult = registBasketService.create(createBasketDTO);
        return "redirect:/basket";
    }
}
