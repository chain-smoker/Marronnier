package com.chainsmoker.marronnier.cocktailrecipe.query.domain.entity;

import com.chainsmoker.marronnier.cocktailrecipe.command.domain.aggregate.EnumType.DifficultyEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "COCKTAILRECIPE_TB")
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QueryCocktailRecipe {
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
    private String recipe;

    @Column
    @Enumerated(EnumType.STRING)
    private DifficultyEnum difficulty;

}
