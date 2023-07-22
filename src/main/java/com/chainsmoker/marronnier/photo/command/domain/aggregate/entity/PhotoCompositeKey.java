package com.chainsmoker.marronnier.photo.command.domain.aggregate.entity;

import com.chainsmoker.marronnier.photo.command.domain.aggregate.entity.EnumType.PhotoCategory;
import com.chainsmoker.marronnier.photo.command.domain.aggregate.vo.OriginVO;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Getter
public class PhotoCompositeKey implements Serializable {
    @Embedded
    private OriginVO originId;

    @Column(name = "PHOTO_CATEGORY", nullable = false)
    @Enumerated(EnumType.STRING)
    private PhotoCategory photoCategory; //사진 구분(조주법, 재료, 피드)

    protected PhotoCompositeKey() {}

    public PhotoCompositeKey(OriginVO originId, PhotoCategory photoCategory) {
        this.originId = originId;
        this.photoCategory = photoCategory;
    }

    public OriginVO getOriginId() {
        return originId;
    }

    public PhotoCategory getPhotoCategory() {
        return photoCategory;
    }

    @Override
    public String toString() {
        return "PhotoCompositeKey{" +
                "originId=" + originId +
                ", photoCategory=" + photoCategory +
                '}';
    }
}
