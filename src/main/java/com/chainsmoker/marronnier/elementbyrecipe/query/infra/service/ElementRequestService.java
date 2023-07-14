package com.chainsmoker.marronnier.elementbyrecipe.query.infra.service;

import com.chainsmoker.marronnier.common.annotation.InfraService;
import com.chainsmoker.marronnier.element.query.application.dto.FindElementDTO;
import com.chainsmoker.marronnier.element.query.application.service.FindElementService;
import com.chainsmoker.marronnier.element.query.domain.entity.QueryElement;
import org.springframework.beans.factory.annotation.Autowired;

@InfraService
public class ElementRequestService
        implements com.chainsmoker.marronnier.
        elementbyrecipe.query.domain.service.ElementRequestService{

    private final FindElementService findElementService;

    @Autowired
    public ElementRequestService(FindElementService findElementService){
        this.findElementService=findElementService;
    }
    @Override
    public FindElementDTO findByElementId(Long elementId){
        return findElementService.findByElementId(elementId);
    }
}
