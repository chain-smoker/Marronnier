package com.chainsmoker.marronnier.basket.command.application.controller;

import com.chainsmoker.marronnier.basket.command.application.dto.DeleteBasketDTO;
import com.chainsmoker.marronnier.basket.command.application.service.DeleteBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/basket")
@SessionAttributes({"id", "name"})
public class DeleteBasketController {

    private final DeleteBasketService deleteBasketService;
    @Autowired
    public DeleteBasketController(DeleteBasketService deleteBasketService) {
        this.deleteBasketService = deleteBasketService;
    }

    @PostMapping("/delete")
    public String addBasket(HttpSession session, @ModelAttribute("delete-basket") DeleteBasketDTO deleteBasketDTO) {
        long memberId = (Long) session.getAttribute("id");

        deleteBasketService.delete(deleteBasketDTO);
        return "redirect:/";
    }
}
