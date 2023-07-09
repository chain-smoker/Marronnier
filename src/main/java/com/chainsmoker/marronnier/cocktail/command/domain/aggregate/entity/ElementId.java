package com.chainsmoker.marronnier.cocktail.command.domain.aggregate.entity;


import javax.persistence.*;

@Embeddable
public class ElementId {
    @Column(name="element_id")
    private Long id;

}
