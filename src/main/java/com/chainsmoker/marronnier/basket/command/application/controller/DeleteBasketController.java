package com.chainsmoker.marronnier.basket.command.application.controller;

import com.chainsmoker.marronnier.basket.command.application.dto.DeleteBasketDTO;
import com.chainsmoker.marronnier.basket.command.application.service.DeleteBasketService;
import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/basket")
@SessionAttributes("user")
public class DeleteBasketController {

    private final DeleteBasketService deleteBasketService;
    @Autowired
    public DeleteBasketController(DeleteBasketService deleteBasketService) {
        this.deleteBasketService = deleteBasketService;
    }

    @PostMapping("/delete")
    public String addBasket(HttpSession session, @ModelAttribute("delete-basket") DeleteBasketDTO deleteBasketDTO) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("user");
        long memberId = sessionUser.getId();

        deleteBasketService.delete(deleteBasketDTO);
        return "redirect:/";
    }
}
