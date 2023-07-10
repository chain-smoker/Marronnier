package com.chainsmoker.marronnier.elementbyrecipe.query.domain.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ELEMENTBYRECIPE_TB")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ElementByRecipeQuery {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="cocktail_id", nullable = false)
    private Long cocktailId;

    @Column(name="element_id",nullable = false)
    private Long elementId;

    @Column
    private String capacity;
}

