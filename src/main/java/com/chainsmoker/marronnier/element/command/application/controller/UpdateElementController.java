package com.chainsmoker.marronnier.element.command.application.controller;

import com.chainsmoker.marronnier.element.command.application.service.UpdateElementService;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UpdateElementController {
    private UpdateElementService updateElementService;

    @Autowired
    public UpdateElementController(UpdateElementService updateElementService){
        this.updateElementService=updateElementService;
    }
    @GetMapping("/cocktail/update/element/{elementId}")
    public String updatePicturePage(@PathVariable Long elementId, Model model){
        model.addAttribute("elementId",elementId);
        model.addAttribute("category","ELEMENT");
        return "cocktail/update/updateElementPicture";
    }
    @PostMapping("/cocktail/update/element")
    public String updatePicture(@RequestParam MultipartFile photo,
                                @RequestParam PhotoCategory category,
                                @RequestParam long originId) throws IOException {

        updateElementService.insertPhoto(originId,photo,category);
        return "redirect:/cocktail/find/element";
    }
}
