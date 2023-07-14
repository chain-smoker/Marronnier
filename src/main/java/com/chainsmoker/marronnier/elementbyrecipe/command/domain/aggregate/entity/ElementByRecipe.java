package com.chainsmoker.marronnier.elementbyrecipe.command.domain.aggregate.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ELEMENTBYRECIPE_TB")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ElementByRecipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "cocktail_id",nullable = false)
    private Long cocktailId;

    @Column(name="element_id",nullable = false)
    private Long elementId;

    @Column
    private String capacity;

    @Builder
    public ElementByRecipe(Long id, Long cocktailId, Long elementId, String capacity) {
        this.id = id;
        this.cocktailId = cocktailId;
        this.elementId = elementId;
        this.capacity = capacity;
    }
}
