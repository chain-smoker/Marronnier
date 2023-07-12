package com.chainsmoker.marronnier.element.query.application.service;

import com.chainsmoker.marronnier.element.query.application.dto.FindElementDTO;
import com.chainsmoker.marronnier.element.query.domain.entity.QueryElement;
import com.chainsmoker.marronnier.element.query.infra.repository.FindElementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindElementService {
    private final FindElementMapper findElementMapper;

    @Autowired
    public FindElementService(FindElementMapper findElementMapper){
        this.findElementMapper=findElementMapper;
    }
    public List<FindElementDTO> findAllElement() {
        List<QueryElement> elements=findElementMapper.findAll();
        System.out.println("elements = " + elements);
        List<FindElementDTO> elementDTOS=new ArrayList<>();
        for (QueryElement element:elements){
            elementDTOS.add(FindElementDTO.entityToDTO(element));
        }
        return elementDTOS;
    }
}
