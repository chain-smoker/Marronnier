package com.chainsmoker.marronnier.cocktail.command.domain.aggregate.entity;

import com.chainsmoker.marronnier.cocktail.command.domain.aggregate.entity.EnumType.DifficultyEnum;
import com.chainsmoker.marronnier.cocktail.command.domain.aggregate.vo.CapacityVO;

import javax.persistence.*;

@Entity
@Table(name = "COCKTAIL_TB")
public class Cocktail {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "cocktail_id")
    private Long id;
    private String name;
    private String description;
    private String classification;
    //a 술 도수
    private String abv;
    @Enumerated(EnumType.STRING)
    private DifficultyEnum difficulty;
    //a 총 용량
    private String allcapacity;

    // 구현 사진 , 요청번호 포링키

}
