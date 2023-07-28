package com.chainsmoker.marronnier.main.query.infra.service;

import com.chainsmoker.marronnier.common.annotation.InfraService;
import com.chainsmoker.marronnier.element.query.application.dto.FindElementDTO;
import com.chainsmoker.marronnier.element.query.application.service.SearchElementService;
import com.chainsmoker.marronnier.main.query.domain.service.ElementQueryRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@InfraService
public class ElementQueryRequestService implements ElementQueryRequest {

    private final SearchElementService searchElementService;

    @Autowired
    public ElementQueryRequestService(SearchElementService searchElementService){
        this.searchElementService=searchElementService;
    }

    @Override
    public List<FindElementDTO> searchElement(String searchWord){
        return  searchElementService.searchElement(searchWord);
    }
}
