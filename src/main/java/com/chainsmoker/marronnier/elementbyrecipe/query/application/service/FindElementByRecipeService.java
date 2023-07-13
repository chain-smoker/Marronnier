package com.chainsmoker.marronnier.elementbyrecipe.query.application.service;

import com.chainsmoker.marronnier.element.query.application.dto.FindElementDTO;
import com.chainsmoker.marronnier.elementbyrecipe.query.application.dto.FindElementByRecipeDTO;
import com.chainsmoker.marronnier.elementbyrecipe.query.infra.repository.FindElementByRecipeMapper;
import com.chainsmoker.marronnier.elementbyrecipe.query.infra.service.ElementRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindElementByRecipeService {

    private FindElementByRecipeMapper findElementByRecipeMapper;
    private ElementRequestService elementRequestService;
    @Autowired
    public FindElementByRecipeService(FindElementByRecipeMapper findElementByRecipeMapper,
                                      ElementRequestService elementRequestService){
        this.findElementByRecipeMapper=findElementByRecipeMapper;
        this.elementRequestService=elementRequestService;
    }
    public List<FindElementDTO> findElementByRecipe(Long recipeId){
        List<Long> elementIdList = findElementByRecipeMapper.findElement(recipeId);
        List<FindElementDTO> elementList=new ArrayList<>();
        // 수정 이 for문은 사실상 쿼리문에서 해결되는 것인데 Element에서 구현한 메소드를 사용하기 위해 이렇게 써야하는게 맞나?
        for (int i=0; i< elementIdList.size(); i++){
            elementList.add(elementRequestService.findByElementId(elementIdList.get(i)));
        }
        return elementList;
    }
}
