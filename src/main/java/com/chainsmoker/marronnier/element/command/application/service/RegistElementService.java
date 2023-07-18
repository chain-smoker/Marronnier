package com.chainsmoker.marronnier.element.command.application.service;

import com.chainsmoker.marronnier.element.command.application.dto.RegistElementDTO;
import com.chainsmoker.marronnier.element.command.domain.aggregate.entity.Element;
import com.chainsmoker.marronnier.element.command.domain.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistElementService {

    private final ElementRepository elementRepository;

    @Autowired
    public RegistElementService(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;

    }

    public void regist(RegistElementDTO elementDTO) {
        System.out.println("Service elementDTO = " + elementDTO);
        //dto -> entity 변환
        Element element = new Element(elementDTO.getName(),elementDTO.getCategoryName());
        System.out.println("entity = " + element);
        elementRepository.save(element);
    }
}
