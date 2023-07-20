package com.chainsmoker.marronnier.basket.command.application.controller;

import com.chainsmoker.marronnier.basket.command.application.dto.DeleteBasketDTO;
import com.chainsmoker.marronnier.basket.command.application.service.DeleteBasketService;
import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

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
    public String addBasket(HttpServletRequest request, Authentication authentication, @RequestParam Map<String, String> requestParam) {
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        long memberId = sessionUser.getId();

        DeleteBasketDTO deleteBasketDTO = new DeleteBasketDTO(Long.parseLong(requestParam.get("basketId")), Long.parseLong(requestParam.get("cockTailRecipeId")));
        deleteBasketService.delete(deleteBasketDTO);
        String referer = request.getHeader("Referer");

        return "redirect:" + referer;
    }
}
