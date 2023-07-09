package com.chainsmoker.marronnier.cocktail.query.domain.entity;

import com.chainsmoker.marronnier.cocktail.command.domain.aggregate.entity.CocktailId;
import com.chainsmoker.marronnier.cocktail.command.domain.aggregate.entity.ElementId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "COCKTAILELEMENT_TB")
public class CocktailElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Embedded
    @Column(name="cocktail_id")
    private CocktailId cocktail;

    @Embedded
    @Column(name="element_id")
    private ElementId element;

}
