package com.chainsmoker.marronnier.element.command.domain.aggregate.entity;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="ELEMENT_TB")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Element {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "element_id")
    private Long id;
    private String name;

    //a VO
    private String category;

    //a 구현 재료사진, 요청번호 포링키

    @Builder
    public Element(Long id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
}
