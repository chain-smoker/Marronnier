package com.chainsmoker.marronnier.photo.command.domain.aggregate.vo;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
public class OriginVO {

    @Column(nullable = false, name= "origin_id")
    private long id;

    protected OriginVO() {}

    public OriginVO(long id) {
        this.id = id;
    }
}
