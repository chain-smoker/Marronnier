package com.chainsmoker.marronnier.cocktailrecipe.query.domain.entity;

import com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.EnumType.DifficultyEnum;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "COCKTAILRECIPE_TB")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CocktailRecipeQueryEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String classification;

    @Column//a 술 도수
    private String abv;

    @Column
    @Enumerated(EnumType.STRING)
    private DifficultyEnum difficultyEnum;

}
