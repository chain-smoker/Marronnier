package com.chainsmoker.marronnier.element.query.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ElementQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "element_id")
    private Long id;
    private String name;

    //a VO
    private String category;

    //a 구현 재료사진, 요청번호 포링키
}