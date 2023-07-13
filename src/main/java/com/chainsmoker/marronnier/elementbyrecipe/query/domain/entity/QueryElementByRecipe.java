package com.chainsmoker.marronnier.elementbyrecipe.query.domain.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ELEMENTBYRECIPE_TB")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QueryElementByRecipe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long cocktailId;

    @Column(nullable = false)
    private Long elementId;

    @Column
    private String capacity;
}

