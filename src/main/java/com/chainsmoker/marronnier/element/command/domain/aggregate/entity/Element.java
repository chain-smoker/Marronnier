package com.chainsmoker.marronnier.element.command.domain.aggregate.entity;


import com.chainsmoker.marronnier.element.command.domain.aggregate.EnumType.CategoryNameEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="ELEMENT_TB")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Long id;

    @Column
    private String name;

    //a VO
    @Column
    @Enumerated(EnumType.STRING)
    private CategoryNameEnum category;

    //a 구현 재료사진, 요청번호 포링키

}
