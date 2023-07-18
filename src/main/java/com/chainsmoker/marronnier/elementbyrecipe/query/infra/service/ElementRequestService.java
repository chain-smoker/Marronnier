package com.chainsmoker.marronnier.elementbyrecipe.query.infra.service;

import com.chainsmoker.marronnier.common.annotation.InfraService;
import com.chainsmoker.marronnier.element.query.application.dto.FindElementDTO;
import com.chainsmoker.marronnier.element.query.application.service.FindElementService;
import com.chainsmoker.marronnier.elementbyrecipe.query.domain.service.ElementRequest;
import org.springframework.beans.factory.annotation.Autowired;

@InfraService
public class ElementRequestService implements ElementRequest {
    private final FindElementService findElementService;

    @Autowired
    public ElementRequestService(FindElementService findElementService){
        this.findElementService=findElementService;
    }
    // 수정 FindElementDTO를 가져와서 썼는데 이 domain에 DTO(Builder Pattrern) 사용해서 영속성을 보장하자
    @Override
    public FindElementDTO findByElementId(Long elementId){
        return findElementService.findByElementId(elementId);
    }
}
