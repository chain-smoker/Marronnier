package com.chainsmoker.marronnier.cocktail.command.domain.aggregate.entity;

import javax.persistence.*;

@Embeddable
public class CocktailId {
    @Column(name = "cocktail_id")
    private Long id;


}
