package com.chainsmoker.marronnier.element.query.application.service;

import com.chainsmoker.marronnier.element.query.application.dto.FindElementDTO;
import com.chainsmoker.marronnier.element.query.domain.entity.QueryElement;
import com.chainsmoker.marronnier.element.query.infra.repository.SearchElementMapper;
import com.chainsmoker.marronnier.element.query.infra.service.ElementPictureRequestService;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchElementService {

    private final SearchElementMapper searchElementMapper;

    private final ElementPictureRequestService pictureRequestService;

    @Autowired
    public SearchElementService(SearchElementMapper searchElementMapper,
                                ElementPictureRequestService pictureRequestService){
        this.searchElementMapper=searchElementMapper;
        this.pictureRequestService=pictureRequestService;
    }
    public List<FindElementDTO> searchElement(String searchWord) {
        List<QueryElement> elements=searchElementMapper.searchElement(searchWord);
        List<FindElementDTO> elementDTOS=new ArrayList<>();
        for (QueryElement element:elements){
            elementDTOS.add(FindElementDTO.entityToDTO(element));
        }
        int elementSize=elementDTOS.size();
        for (int i=0; i<elementSize; i++){
            elementDTOS.get(i).setImg(
                    pictureRequestService.findPictureByCategory(elementDTOS.get(i).getId(), PhotoCategory.ELEMENT).get(0).getPhotoRoot());
        }
        return elementDTOS;
    }
}
