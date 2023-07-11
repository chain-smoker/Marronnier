package com.chainsmoker.marronnier.element.command.domain.aggregate.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="ELEMENT_TB")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "element_id")
    private Long id;
    private String name;

    //a VO
    private String category;

    //a 구현 재료사진, 요청번호 포링키

    @Builder
    public Element(String name, String category) {
        this.name = name;
        this.category = category;
    }
}
