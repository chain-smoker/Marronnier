package com.chainsmoker.marronnier.element.query.domain.entity;

import com.chainsmoker.marronnier.element.command.domain.aggregate.EnumType.CategoryNameEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="ELEMENT_TB")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QueryElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private CategoryNameEnum category;

    //a 구현 재료사진, 요청번호 포링키
}