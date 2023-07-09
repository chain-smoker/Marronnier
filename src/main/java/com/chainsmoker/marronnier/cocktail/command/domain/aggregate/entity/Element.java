package com.chainsmoker.marronnier.cocktail.command.domain.aggregate.entity;


import javax.persistence.*;

@Entity
@Table(name="ELEMENT_TB")
public class Element {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "element_id")
    private Long id;
    private String name;
    private String elementabv;

    //a VO
    private String capacity;
    private String category;

    // 구현 재료사진, 요청번호 포링키
}
