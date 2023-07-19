package com.chainsmoker.marronnier.elementbyrecipe.command.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegistElementByRecipeDTO {

    private Long id;
    private Long cocktailId;
    private Long elementId;
    private String capacity;

}
