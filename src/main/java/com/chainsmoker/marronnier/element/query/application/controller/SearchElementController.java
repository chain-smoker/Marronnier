package com.chainsmoker.marronnier.element.query.application.controller;

import com.chainsmoker.marronnier.element.query.application.dto.FindElementDTO;
import com.chainsmoker.marronnier.element.query.application.service.SearchElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class SearchElementController {
    private final SearchElementService searchElementService;
    @Autowired
    public SearchElementController(SearchElementService searchElementService){
        this.searchElementService=searchElementService;
    }
    @GetMapping("/search")
    public String test(){
        return "cocktail/searchMain";
    }

    @ResponseBody
    @PostMapping("/searchword")
    public List<FindElementDTO> test1(@RequestBody Map<String, String> map){
        String searchWord=map.get("searchWord");
        List<FindElementDTO> elements=searchElementService.searchElement(searchWord);
        return elements;
    }
}
