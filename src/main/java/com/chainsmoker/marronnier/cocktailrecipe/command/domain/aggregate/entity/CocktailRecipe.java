package com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.entity;

import com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.EnumType.DifficultyEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "COCKTAILRECIPE_TB")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CocktailRecipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String classification;

    @Column
    private String abv;

    @Column
    @Enumerated(EnumType.STRING)
    private DifficultyEnum difficulty;

    //a 구현 사진 , 요청번호 포링키
    public CocktailRecipe(String name, String description, String classification, String abv, DifficultyEnum difficulty) {
        this.name = name;
        this.description = description;
        this.classification = classification;
        this.abv = abv;
        this.difficulty = difficulty;
    }

}
