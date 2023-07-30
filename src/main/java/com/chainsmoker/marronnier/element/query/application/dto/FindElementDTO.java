package com.chainsmoker.marronnier.element.query.application.dto;


import com.chainsmoker.marronnier.element.command.domain.aggregate.EnumType.CategoryNameEnum;
import com.chainsmoker.marronnier.element.query.domain.entity.QueryElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class FindElementDTO {
    private Long id;
    private String name;
    private CategoryNameEnum category;
    private String img;

    public static FindElementDTO entityToDTO(QueryElement queryElement){
        FindElementDTO elementDTO=new FindElementDTO();
        elementDTO.setId(queryElement.getId());
        elementDTO.setName(queryElement.getName());
        elementDTO.setCategory(queryElement.getCategory());
        return elementDTO;
    }

    @Override
    public String toString() {
        return "FindElementDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", img='" + img + '\'' +
                '}';
    }
}
