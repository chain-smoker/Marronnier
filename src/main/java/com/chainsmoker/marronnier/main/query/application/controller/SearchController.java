package com.chainsmoker.marronnier.main.query.application.controller;

import com.chainsmoker.marronnier.cocktailrecipe.query.application.dto.FindCocktailRecipeDTO;
import com.chainsmoker.marronnier.configuration.auth.SessionUser;
import com.chainsmoker.marronnier.element.query.application.dto.FindElementDTO;
import com.chainsmoker.marronnier.main.query.application.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Controller
public class SearchController {
    private final SearchService service;

    @Autowired
    public SearchController(SearchService service) {
        this.service = service;
    }

    @GetMapping("/cocktail/search")
    public String Test(Model model, Authentication authentication) {
        System.out.println("page이동 통과~@!");
        SessionUser sessionUser = (SessionUser) authentication.getPrincipal();
        boolean memberIsAuthenticated = authentication.isAuthenticated();
        model.addAttribute("member", sessionUser);
        model.addAttribute("memberIsAuthenticated", memberIsAuthenticated);
        return "main/search";
    }

    @ResponseBody
    @PostMapping("/search")
    public List<Object> searchResult(@RequestBody Map<String, String> searchInfo) {
        System.out.println("통과!");
        String category = searchInfo.get("searchCategory");
        String word = searchInfo.get("searchWord");
        if(category.equals("element")){
            List<FindElementDTO> elements = service.searchElement(word);
            System.out.println("elements = " + elements);
            return Collections.singletonList(elements);
        }else if(category.equals("cocktail")){
            List<FindCocktailRecipeDTO> recipes=service.searchCocktailRecipe(word);
            System.out.println("recipes = " + recipes);
            return Collections.singletonList(recipes);
        }
        return null;
    }
}