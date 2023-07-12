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
public class QueryCocktailRecipe {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
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
    private DifficultyEnum difficulty;

    //a 삭제 필요
    @Override
    public String toString() {
        return "QueryCocktailRecipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", classification='" + classification + '\'' +
                ", abv='" + abv + '\'' +
                ", difficulty=" + difficulty +
                '}';
    }
}
