package com.chainsmoker.marronnier.element.command.application.dto;

import com.chainsmoker.marronnier.element.command.domain.aggregate.EnumType.CategoryNameEnum;
import com.chainsmoker.marronnier.element.command.domain.aggregate.entity.Element;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegistElementDTO {

    private Long id;
    private String name;
    private CategoryNameEnum categoryName;

    public static RegistElementDTO toRegistElementDTO(Element element) {
        RegistElementDTO elementDTO = new RegistElementDTO();
        elementDTO.setId(element.getId());
        elementDTO.setName(element.getName());
        elementDTO.setCategoryName(element.getCategory());
        return elementDTO;
    }

}
