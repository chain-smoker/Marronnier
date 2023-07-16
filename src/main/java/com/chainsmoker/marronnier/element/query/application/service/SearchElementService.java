package com.chainsmoker.marronnier.element.query.application.service;

import com.chainsmoker.marronnier.element.query.application.dto.FindElementDTO;
import com.chainsmoker.marronnier.element.query.domain.entity.QueryElement;
import com.chainsmoker.marronnier.element.query.infra.repository.SearchElementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchElementService {

    private final SearchElementMapper searchElementMapper;

    @Autowired
    public SearchElementService(SearchElementMapper searchElementMapper){
        this.searchElementMapper=searchElementMapper;
    }
    public List<FindElementDTO> searchElement(String searchWord) {
        List<QueryElement> elements=searchElementMapper.searchElement(searchWord);
        List<FindElementDTO> elementDTOS=new ArrayList<>();
        for (QueryElement element:elements){
            elementDTOS.add(FindElementDTO.entityToDTO(element));
        }
        return elementDTOS;

    }
}
